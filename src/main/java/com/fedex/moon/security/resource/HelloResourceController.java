package com.fedex.moon.security.resource;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/hello")
public class HelloResourceController {
	
	@GetMapping ("/message")
	public String message () {
		return "HELLO!!! Welcome to my WORLD!";
	}
	
	@RequestMapping ("/userinfo")
	public Principal user (Principal pal) {
		System.out.println(pal);
		return pal;
	}
}
