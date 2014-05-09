package com.flacom.jpa.hibernate.example.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

@Controller
@RequestMapping(value={""})
public class HomeController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value={"/{username}"}, method=RequestMethod.GET)
	public ModelAndView home(@PathVariable("username") String username , @RequestParam(value = "date", required=false) final  String date) throws Exception{
		
		Map<String, Object> params = new HashMap<String, Object>();
		Date date2;
		if (date !=null)
		{
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			date2 = formatter.parse(date);
		}
		else
		{
			date2 = new Date();			
		}
		
		User user = userService.getByName(username);
		
		if (user!=null)
		{
			List<Post> posts = userService.getLastestPostsByUser(user.getId(), date2);
			params.put("posts", posts);
			
			Post post = userService.getLastPostByUser(user.getId(), date2);
					
			params.put("post", post);
		}
		
		params.put("user", user);
		
		return new ModelAndView("home", params);
	}
	
	@RequestMapping(value={"/{username}/{id}"}, method=RequestMethod.GET)
	public ModelAndView home(@PathVariable("username") String username,@PathVariable("id") int id , @RequestParam(value = "date", required=false) final  String date) throws Exception{

		Map<String, Object> params = new HashMap<String, Object>();
		
		Date date2;
		if (date !=null)
		{
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			date2 = formatter.parse(date);
		}
		else
		{
			date2 = new Date();			
		}
		
		User user = userService.getByName(username);
		
		if (user!=null)
		{
			List<Post> posts = userService.getLastestPostsByUser(user.getId(), date2);
			params.put("posts", posts);
			
			Post post;
			
			if (id>0)
			{
				post = userService.getPostByUser(user.getId(),id);
			}
			else
			{
				post = userService.getLastPostByUser(user.getId(), date2);
			}
			
			params.put("post", post);
		}
		
		
		
		params.put("user", user);
		
		return new ModelAndView("home", params);
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index() throws Exception{
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		List<Post> posts = userService.getLastestPostsByUser(0, new Date());
		params.put("posts", posts);

		return new ModelAndView("index", params);
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
