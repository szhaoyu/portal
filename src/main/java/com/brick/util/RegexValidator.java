package com.brick.util;

import java.util.regex.Pattern;


public class RegexValidator {

	private String regex;
	private Pattern pattern;
	
	public RegexValidator(String regexStr) {
		this.regex = regexStr;
		this.pattern = Pattern.compile(regex);
	}
	
	public boolean validate(  String input ) {
		return pattern.matcher(input).matches();
	}

}

