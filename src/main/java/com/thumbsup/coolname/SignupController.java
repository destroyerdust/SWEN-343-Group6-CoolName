package com.thumbsup.coolname;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignupController {

	@RequestMapping("account/signup")
	public String getSignup()
	{
		return "signup";
	}
}
