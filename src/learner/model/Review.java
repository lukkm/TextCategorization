package learner.model;

import java.util.ArrayList;
import java.util.List;

public class Review {

	private boolean positive;
	private List<String> tokens = new ArrayList<String>();
	
	public Review(boolean positive) {
		this.positive = positive;
	}
	
	public boolean isPositive() {
		return positive;
	}
	
	public void addToken(String token) {
		this.tokens.add(token);
	}
	
	public List<String> getTokens() {
		return tokens;
	}
	
}
