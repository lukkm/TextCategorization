package learner.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import learner.model.Review;
import learner.model.Token;

public class ReviewParser {

	private List<Token> applicationTokens = new ArrayList<Token>();
	private List<String> removingPatterns = new ArrayList<String>();

	/**
	 * Add token to apply when processing the review.
	 */
	public void addProcessingToken(Token token) {
		this.applicationTokens.add(token);
	}

	/**
	 * Add token to apply when processing the review.
	 */
	public void addProcessingToken(String pattern, String token) {
		addProcessingToken(new Token(pattern, token));
	}

	/**
	 * Add token to apply when processing the review.
	 */
	public void addRemovingPattern(String pattern) {
		removingPatterns.add(pattern);
	}

	/**
	 * Parses a review from a file applying all the configured processing.
	 */
	public Review parseReviewFile(File reviewFile, boolean isPositive) {
		System.out.println(reviewFile.getName());
		try {
			Scanner in = new Scanner(new FileReader(reviewFile));
			StringBuilder strBuilder = new StringBuilder();
			while (in.hasNextLine()) {
				strBuilder.append(in.nextLine());
			}

			/*
			 * Build the list with the separated tokens
			 */
			String reviewString = strBuilder.toString().toLowerCase();
			String[] reviewParticles = reviewString.split("\\t");

			Review review = new Review(isPositive);

			/*
			 * Start processing the token list
			 */
			for (String particle : reviewParticles) {

				/*
				 * Remove the particle if it's one of the undesired.
				 */
				for (String pattern : removingPatterns) {
					if (particle.matches(pattern)) {
						System.out.println("Removing: " + particle);
						continue;
					}
				}

				/*
				 * Change the particle for a specific token if needed. If more
				 * than one token matches, this will only use the first one.
				 */
				for (Token token : applicationTokens) {
					if (particle.matches(token.getTokenApplicationRegex())) {
						// Add the specified token for this matching.
						review.addToken(token.getName());
						continue;
					}
				}

				/*
				 * If we got here, we don't need any further processing, so just
				 * add the particle to the review token list.
				 */
				review.addToken(particle);
			}

		} catch (FileNotFoundException e) {
			System.out.println("File " + reviewFile.getName() + " not found.");
		}
		return new Review(isPositive);
	}
}
