package learner.model;

import java.util.regex.Pattern;

public class Token {

	private Pattern tokenApplicationRegex;
	private String name;
	
	public Token(Pattern pattern, String name) {
		this.tokenApplicationRegex = pattern;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public Pattern getTokenApplicationRegex() {
		return tokenApplicationRegex;
	}
}
