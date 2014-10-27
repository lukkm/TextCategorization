package learner.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import learner.model.Review;
import learner.model.Token;

public class ReviewParser {

	private List<Token> applicationTokens = new ArrayList<Token>();

	/**
	 * Add token to apply when processing the review.
	 */
	public void addProcessingToken(Token token) {
		this.applicationTokens.add(token);
	}

	/**
	 * Add token to apply when processing the review.
	 */
	public void addProcessingToken(Pattern pattern, String token) {
		addProcessingToken(new Token(pattern, token));
	}

	/**
	 * Parses a review from a file applying all the configured processing.
	 */
	public Review parseReviewFile(File reviewFile, boolean isPositive) {
		return new Review(isPositive);
	}

}
