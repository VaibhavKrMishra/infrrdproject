package com.example.controller;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.beans.ApplicationResponse;
import com.example.beans.ThreadProcessor;
import com.example.dto.RequestSyntax;



/**
 * @author Vaibhav
 */

@RestController
@CrossOrigin
@RequestMapping("/Utility")
public class RegexController {

	@PostMapping("/Regex")
	public ApplicationResponse match(@RequestBody RequestSyntax requestData) throws InterruptedException {
		Thread t1 = Thread.currentThread();
		ThreadProcessor tp = new ThreadProcessor(requestData.getRegex(), requestData.getTextBody());
		Thread t = new Thread(tp);
		t.start();
		t1.join(500);
		return tp.data();
		
		}
	}
