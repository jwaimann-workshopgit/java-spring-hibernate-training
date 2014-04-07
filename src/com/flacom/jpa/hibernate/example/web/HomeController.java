package com.flacom.jpa.hibernate.example.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.flacom.jpa.hibernate.example.domain.user.User;
import com.flacom.jpa.hibernate.example.service.user.UserService;

@Controller
@RequestMapping(value={""})
public class HomeController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value={"","/"})
	public ModelAndView home() throws Exception{
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		List<User> users = userService.getAll();
		
		params.put("users", users);
		
		params.put("user", new User());
		
		return new ModelAndView("home", params);
	}
	
	@RequestMapping("/save")
	public ModelAndView save(@ModelAttribute("user") User user) throws Exception{
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		if(!StringUtils.hasText(user.getUsername())){
			
			params.put("usernameMessage", "Input required");
			
			return new ModelAndView("home", params);
			
		}
		
		userService.create(user);
		
		return new ModelAndView("redirect:/");
	}
}
