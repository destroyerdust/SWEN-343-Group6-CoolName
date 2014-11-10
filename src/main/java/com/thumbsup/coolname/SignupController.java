package com.thumbsup.coolname;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.thumbsup.coolname.entity.User;
import com.thumbsup.coolname.entity.Vehicle;
import com.thumbsup.coolname.service.UserManager;

@Controller
public class SignupController {

	@RequestMapping(value="account/signup", method=RequestMethod.GET)
	public String getSignup()
	{
		return "signup";
	}
	
	@RequestMapping(value="account/signup", method=RequestMethod.POST)
	public ModelAndView postSignup(@RequestParam(value="usr", required=true, defaultValue="") String userName,
							@RequestParam(value="psw", required=true, defaultValue="") String password,
							@RequestParam(value="name", required=true, defaultValue="") String name,
							@RequestParam(value="lstn", required=true, defaultValue="") String lastName,
							@RequestParam(value="cell", required=true, defaultValue="") String cellPhone,
							@RequestParam(value="caraswr", required=true, defaultValue="") String carAnswer,
							@RequestParam(value="model", required=false) String model,
							@RequestParam(value="seats", required=false) String seats,
							@RequestParam(value="desc", required=true, defaultValue="") String description,
							HttpServletRequest request)
	{
		String page = "";
		if(userName.equals("") || password.equals("") || name.equals("") || lastName.equals("") ||
				cellPhone.equals("") || carAnswer.equals("") || description.equals(""))
		{
			page = "signup";
			request.setAttribute("s", false);
		}
		else
		{
			int type = UserType.PASSENGER.getId();
			Vehicle v = null;
			if(carAnswer.equalsIgnoreCase("Yes"))
			{
				v = new Vehicle();
				v.setDescription(description);
				v.setModel(model);
				v.setNumSeats(Integer.parseInt(seats));
				type = UserType.DRIVER.getId();
			}
			UserManager manager = new UserManager();
			User u = manager.createUser(userName, name, lastName, password, cellPhone, type, v);
			if(u == null)
			{
				page = "signup";
				request.setAttribute("s", false);
			}
			else
			{
				page = "redirect:/";
				u = manager.login(userName, password);
				password = null;
				HttpSession session = request.getSession();
				session.setAttribute("auth", u.getUserId());
			}
		}
		return new ModelAndView(page);
	}
}
