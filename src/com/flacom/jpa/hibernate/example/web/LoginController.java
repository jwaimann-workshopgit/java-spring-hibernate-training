package com.flacom.jpa.hibernate.example.web;



import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;





import com.flacom.jpa.hibernate.example.domain.entity.User;
import com.flacom.jpa.hibernate.example.service.user.UserService;
import com.flacom.jpa.hibernate.example.utils.EncryptUtils;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.oauth2.Oauth2;
import com.google.api.services.oauth2.model.Tokeninfo;



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
	
	

    static String CLIENT_ID = "251114476069.apps.googleusercontent.com";
    static String CLIENT_SECRET = "biGX_KSudbHPTXtMKFDma-T1";

	
	@RequestMapping("/save")
	public ModelAndView save(@ModelAttribute("user") User user, HttpServletRequest request) throws Exception{

        NetHttpTransport TRANSPORT = new NetHttpTransport();
        GsonFactory JSONFACTORY = new GsonFactory();

        try
        {
		    GoogleTokenResponse tokenResponse =
			        new GoogleAuthorizationCodeTokenRequest(TRANSPORT, JSONFACTORY,
			            CLIENT_ID, CLIENT_SECRET, user.getToken(), "postmessage").execute();
	
			GoogleCredential credential = new GoogleCredential.Builder()
			        .setJsonFactory(JSONFACTORY)
			        .setTransport(TRANSPORT)
			        .setClientSecrets(CLIENT_ID, CLIENT_SECRET)
			        .build()
			        .setFromTokenResponse(tokenResponse);
			
			Oauth2 oauth2 = new Oauth2.Builder(
			        TRANSPORT, JSONFACTORY, credential).build();
			
			Tokeninfo tokenInfo = oauth2.tokeninfo()
			        .setAccessToken(credential.getAccessToken()).execute();
	       
	
			// It has value only the first time user does log in, 
			//to allow the application to do api calls without requesting user interaction
		    String token = credential.getRefreshToken(); 
		    
		    String id = tokenInfo.getUserId();
			user.setToken(id);
			user.setUsername(ReplaceSpecialCharacters(user.getUsername()));
			
			User existingUser = userService.getByToken(user.getToken());
		
			if (existingUser==null)
			{
				user = AvoidUsernameCollision(user);
				userService.create(user);
			}
			
			request.getSession().setAttribute("userToken",EncryptUtils.base64encode(user.getToken()));
			
			return new ModelAndView("redirect:/controlpanel/home/");
        }
        catch(Exception e)
        {
        	return new ModelAndView("error");
        }
	}

	private User AvoidUsernameCollision(User user) throws Exception {
		User existingUsername = userService.getByName(user.getUsername());
		while (existingUsername!=null)
		{ 
			user.setUsername(user.getUsername()+"2");
			existingUsername = userService.getByName(user.getUsername());
		}
		return user;
	}
	
	private String ReplaceSpecialCharacters(String input) {

	    String original = "áàäéèëíìïóòöúùuñç";
	    String ascii = "aaaeeeiiiooouuunc";
	    String output = input;
	    for (int i=0; i<original.length(); i++) {
	        output = output.replace(original.charAt(i), ascii.charAt(i));
	    }
	    return output;
	}

}
