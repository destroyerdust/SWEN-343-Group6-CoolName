package com.thumbsup.coolname;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.thumbsup.coolname.entity.User;
import com.thumbsup.coolname.service.UserManager;

@Controller
public class LoginController {

	@RequestMapping(value="/account/login", method=RequestMethod.GET)
	public String getLogin(HttpServletRequest request)
	{
		request.setAttribute("l", true);
		return "login";
	}
	
	@RequestMapping(value="/account/login", method=RequestMethod.POST)
	public String postLogin(@RequestParam(value="usr", required=true, defaultValue="") String username,
			@RequestParam(value="psw", required=true, defaultValue="") String password,
			HttpServletResponse response, HttpServletRequest request)
	{
		String page = "";
		Cookie cookie = null; 
		if(username.equals("") || password.equals(""))
		{
			page = "login";
			request.setAttribute("l", false);
		}
		else
		{
			UserManager manager = new UserManager();
			User u = manager.login(username, password);
			password = null;
			if( u == null)
			{
				page = "login";
				request.setAttribute("l", false);
			}
			else
			{
				cookie = new Cookie("auth", u.getUserId().toString());
				page = "home";
				response.addCookie(cookie);
			}
		}
		
		return page;
	}
}
