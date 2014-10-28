package learner.model;

import java.util.regex.Pattern;

public class Token {

	private String tokenApplicationRegex;
	private String name;
	
	public Token(String pattern, String name) {
		this.tokenApplicationRegex = pattern;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getTokenApplicationRegex() {
		return tokenApplicationRegex;
	}
}
