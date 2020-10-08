package com.example.beans;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import lombok.Data;

@Data
public class ThreadProcessor implements Runnable {
	private String match = null;
	private boolean error = true;
	private String regex;
	private String textBody;
	public ThreadProcessor( String a, String b) {
		// TODO Auto-generated constructor stub
		regex =a;
		textBody =b;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub

			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(textBody);
			boolean matchFound = matcher.find();
			if (matchFound) {
				match = matcher.group();
				error = false;
			} else {
				match = null;
				error = false;
		}
	}
	
	public ApplicationResponse data() {
		return ApplicationResponse.success(match, error);
	}

}