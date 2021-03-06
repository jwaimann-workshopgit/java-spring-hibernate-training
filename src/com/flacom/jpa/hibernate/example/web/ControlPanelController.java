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
		Map<String, Object> params = new HashMap<String, Object>();
		String value = EncryptUtils.base64decode((String)request.getSession().getAttribute("userToken"));
		User user = userService.getByToken(value);
		params.put("user", user);
		List<Post> posts = userService.getPostsByUser(user.getId());
		params.put("posts", posts);
		return new ModelAndView("controlpanel", params);
	};
	
	@RequestMapping(value="/add/", method=RequestMethod.GET)
	public ModelAndView add(HttpServletRequest request) throws Exception{
		Map<String, Object> params = new HashMap<String, Object>();
		String value = EncryptUtils.base64decode((String)request.getSession().getAttribute("userToken"));
		User user = userService.getByToken(value);

		params.put("post", new Post());
		
		params.put("user", user);
		
		return new ModelAndView("addpost", params);
	};
	
	
	@RequestMapping(value={"/edit/{postid}"}, method=RequestMethod.GET)
	public ModelAndView edit(HttpServletRequest request, @PathVariable("postid")  int id) throws Exception{
		Map<String, Object> params = new HashMap<String, Object>();
		String value = EncryptUtils.base64decode((String)request.getSession().getAttribute("userToken"));
		User user = userService.getByToken(value);
		if (id==0)
		{
		   params.put("post", new Post());
		}
		else
		{
			Post post = userService.getPostByUser(user.getId(), id);
			params.put("post", post );
		}
		
		params.put("user", user);

		return new ModelAndView("addpost", params);
	};
	
	@RequestMapping(value={"/remove/{postid}"}, method=RequestMethod.GET)
	public ModelAndView remove(HttpServletRequest request, @PathVariable("postid")  int id) throws Exception{
		String value = EncryptUtils.base64decode((String)request.getSession().getAttribute("userToken"));
		User user = userService.getByToken(value);
		
		userService.remove(id, user.getId());

		return new ModelAndView("redirect:/controlpanel/home/");
	};
	
	@RequestMapping(value={"/logout"}, method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) throws Exception{

		request.getSession().invalidate();
		return new ModelAndView("redirect:../");
	};
	

	@RequestMapping(value={"/add/save","/edit/save"}, method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("post") Post post, HttpServletRequest request) throws Exception{
		String value = EncryptUtils.base64decode((String)request.getSession().getAttribute("userToken"));
		
		User user = userService.getByToken(value);
		
		if (user!=null)
		{
			post.setUser(user);
			post.setDate(new Date());
			
			if (post.getId()==0)
				userService.create(post);
			else
				userService.update(post);
		}
		
		return new ModelAndView("redirect:/controlpanel/home/");
	}
}
