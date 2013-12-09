package com.tcy.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.tellme.entity.User;

@Controller
@RequestMapping("/user") 
public class LoginController {
	private static final Logger logger = Logger.getLogger(LoginController.class);
	@RequestMapping(value="/login")  
	public String UserLogin()
	{
		logger.info("request user login -+");
		return "user/loginsucc";
	}

}
