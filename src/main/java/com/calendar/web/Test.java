package com.calendar.web;

import java.util.LinkedHashMap;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class Test {
	@RequestMapping("/")
	public String login(OAuth2Authentication authentication) {

		LinkedHashMap<String, String> details = (LinkedHashMap<String, String>) authentication.getUserAuthentication()
				.getDetails();

		return "redirect:http://localhost:8081";

	}

	@RequestMapping("/yo")
	@ResponseBody
	public String yo(OAuth2Authentication authentication) {

		LinkedHashMap<String, String> details = (LinkedHashMap<String, String>) authentication.getUserAuthentication()
				.getDetails();

		return "Hi " + details.get("email");
	}

}
