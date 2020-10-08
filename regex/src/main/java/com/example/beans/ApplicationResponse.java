package com.example.beans;

import lombok.Data;
/*
 *@author Vaibhav
  */


@Data 
public class ApplicationResponse {
	
	private String match;
    private boolean error;


    public static ApplicationResponse success(final String match, final boolean error) {
        final ApplicationResponse response = new ApplicationResponse();
        response.setMatch(match);
        response.setError(error);
        return response;
    }
	
}