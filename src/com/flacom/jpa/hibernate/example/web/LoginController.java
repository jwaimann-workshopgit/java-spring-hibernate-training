package com.flacom.jpa.hibernate.example.web;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.flacom.jpa.hibernate.example.domain.entity.Post;
import com.flacom.jpa.hibernate.example.domain.entity.User;
import com.flacom.jpa.hibernate.example.service.user.UserService;
import com.flacom.jpa.hibernate.example.utils.EncryptUtils;

@Controller
@RequestMapping(value={"/user"})
public class LoginController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value={"","/login"}, method = RequestMethod.GET)
    public ModelAndView index() throws Exception{
		User user = new User();	
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("user", user);

		return new ModelAndView("login", params);
	}
	
	

	
	@RequestMapping("/save")
	public ModelAndView save(@ModelAttribute("user") User user, HttpServletRequest request) throws Exception{
		
		User existingUser = userService.getByToken(user.getToken());
		
		//If new user, it does registration
		if (existingUser==null)
			userService.create(user);
		
		request.getSession().setAttribute("userToken",EncryptUtils.base64encode(user.getToken()));
		
		return new ModelAndView("redirect:/controlpanel/home/");
	}

}
