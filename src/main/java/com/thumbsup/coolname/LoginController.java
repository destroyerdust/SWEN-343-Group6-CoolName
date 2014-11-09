package com.thumbsup.coolname;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.thumbsup.coolname.entity.User;
import com.thumbsup.coolname.service.UserManager;

@Controller
public class LoginController {

	@RequestMapping(value="/account/login", method=RequestMethod.GET)
	public String getLogin()
	{
		return "login";
	}
	
	@RequestMapping(value="/account/login", method=RequestMethod.POST)
	public String postLogin(@RequestParam(value="usr", required=true, defaultValue="") String username,
			@RequestParam(value="psw", required=true, defaultValue="") String password,
			HttpServletResponse response)
	{
		String page = "";
		if(username.equals("") || password.equals(""))
		{
			page = "login";
		}
		else
		{
			
//			String encryptedPass = 
			Cookie cookie = null;
			UserManager manager = new UserManager();
			User u = manager.login(username, password);
			if( u == null)
			{
				page = "login";
				cookie = new Cookie("auth","");
			}
			else
			{
				cookie = new Cookie("auth", u.getUserId().toString());
				page = "home";
			}
			response.addCookie(cookie);
		}
		return page;
	}
}
