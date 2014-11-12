package com.thumbsup.coolname;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.thumbsup.coolname.entity.User;
import com.thumbsup.coolname.service.UserManager;

@Controller
public class LoginController {

	@RequestMapping(value = "/account/login", method = RequestMethod.GET)
	public String getLogin(HttpServletRequest request) {
		request.setAttribute("l", true);
		return "login";
	}

	@RequestMapping(value = "/account/login", method = RequestMethod.POST)
	public ModelAndView postLogin(
			@RequestParam(value = "usr", required = true, defaultValue = "") String username,
			@RequestParam(value = "psw", required = true, defaultValue = "") String password,
			HttpServletRequest request) {
		String page = "";
		if (username.equals("") || password.equals("")) {
			page = "login";
			request.setAttribute("l", false);
		} else {
			UserManager manager = new UserManager();
			User u = manager.login(username, password);
			password = null;
			if (u == null) {
				page = "login";
				request.setAttribute("l", false);
			} else {
				page = "redirect:/";
				HttpSession session = request.getSession();
				session.setAttribute("auth", u.getUserId());
			}
		}

		return new ModelAndView(page);
	}
	@RequestMapping(value="/account/logout", method=RequestMethod.GET)
	public ModelAndView fireLogout(HttpServletRequest request){
		request.getSession().invalidate();
		return new ModelAndView("redirect:/");
	}
}
