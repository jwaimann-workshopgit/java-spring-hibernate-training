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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.flacom.jpa.hibernate.example.domain.entity.Post;
import com.flacom.jpa.hibernate.example.domain.entity.User;
import com.flacom.jpa.hibernate.example.service.user.UserService;
import com.flacom.jpa.hibernate.example.utils.EncryptUtils;

@Controller
@RequestMapping(value={"/controlpanel/"})
public class ControlPanelController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/home/", method=RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request) throws Exception{
		String value = EncryptUtils.base64decode((String)request.getSession().getAttribute("userToken"));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userToken", value);
		return new ModelAndView("controlpanel", params);
	};
	
	@RequestMapping(value="/add/", method=RequestMethod.GET)
	public ModelAndView add(HttpServletRequest request) throws Exception{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("post", new Post());
		//TODO: add user id from session , so when it saves and 
		return new ModelAndView("addpost", params);
	};
	
	@RequestMapping(value="/add/save", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("post") Post post) throws Exception{
		User user = new User();
		user.setId(7);
		post.setUser(user);
		post.setDate(new Date());
		userService.create(post);
		
		return new ModelAndView("redirect:/controlpanel/home/");
	}
}
