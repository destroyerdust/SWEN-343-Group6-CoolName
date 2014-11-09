package com.thumbsup.coolname;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.thumbsup.coolname.entity.User;
import com.thumbsup.coolname.entity.Vehicle;

@Controller
public class SignupController {

	@RequestMapping(value="account/signup", method=RequestMethod.GET)
	public String getSignup()
	{
		return "signup";
	}
	
	@RequestMapping(value="account/signup", method=RequestMethod.POST)
	public String postSignup(@RequestParam(value="usr", required=true) String userName,
							@RequestParam(value="psw", required=true) String password,
							@RequestParam(value="name", required=true) String name,
							@RequestParam(value="lstn", required=true) String lastName,
							@RequestParam(value="cell", required=true) String cellPhone,
							@RequestParam(value="caraswr", required=true) String carAnswer,
							@RequestParam(value="model", required=false) String model,
							@RequestParam(value="seats", required=false) String seats,
							@RequestParam(value="desc", required=true) String description)
	{
		User u = new User();
		u.setFirstName(name);
		u.setLastName(lastName);
		u.setPassword(password);
		u.setPhoneNumber(cellPhone);
		u.setUserName(userName);
		if(carAnswer.equalsIgnoreCase("Yes"))
		{
			Vehicle v = new Vehicle();
			v.setDescription(description);
			v.setModel(model);
			v.setNumSeats(Integer.parseInt(seats));
//			v.set
		}
		
		return "home";
	}
}
