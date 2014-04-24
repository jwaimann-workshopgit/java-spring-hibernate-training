package com.flacom.jpa.hibernate.example.web;


import java.io.IOException;
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

import com.fasterxml.jackson.core.JsonFactory;
import com.flacom.jpa.hibernate.example.domain.entity.Post;
import com.flacom.jpa.hibernate.example.domain.entity.User;
import com.flacom.jpa.hibernate.example.service.user.UserService;
import com.flacom.jpa.hibernate.example.utils.EncryptUtils;
import com.google.api.client.auth.oauth2.TokenResponseException;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.client.auth.oauth2.*;
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
		
		////////
        NetHttpTransport transport = new NetHttpTransport();
        JacksonFactory jsonfactory = new JacksonFactory();
		try {
		    // Upgrade the authorization code into an access and refresh token.
		    GoogleTokenResponse tokenResponse =
		        new GoogleAuthorizationCodeTokenRequest(transport, jsonfactory,
		            CLIENT_ID, CLIENT_SECRET, user.getToken(), "postmessage").execute();
		    // Create a credential representation of the token data.
		    GoogleCredential credential = new GoogleCredential.Builder()
		        .setJsonFactory(jsonfactory)
		        .setTransport(transport)
		        .setClientSecrets(CLIENT_ID, CLIENT_SECRET).build()
		        .setFromTokenResponse(tokenResponse);

		    // Check that the token is valid.
		    Oauth2 oauth2 = new Oauth2.Builder(
		    		transport, jsonfactory, credential).build();
		    Tokeninfo tokenInfo = oauth2.tokeninfo()
		        .setAccessToken(credential.getAccessToken()).execute();
//		    // If there was an error in the token info, abort.
//		    if (tokenInfo.containsKey("error")) {
//		      response.status(401);
//		      return GSON.toJson(tokenInfo.get("error").toString());
//		    }
//		    // Make sure the token we got is for the intended user.
//		    if (!tokenInfo.getUserId().equals(gPlusId)) {
//		      response.status(401);
//		      return GSON.toJson("Token's user ID doesn't match given user ID.");
//		    }
//		    // Make sure the token we got is for our app.
//		    if (!tokenInfo.getIssuedTo().equals(CLIENT_ID)) {
//		      response.status(401);
//		      return GSON.toJson("Token's client ID does not match app's.");
//		    }
//	      } catch (TokenResponseException e) {
//		    response.status(500);
//		    return GSON.toJson("Failed to upgrade the authorization code.");
//		  } catch (IOException e) {
//		    response.status(500);
//		    return GSON.toJson("Failed to read token data from Google. " +
//		        e.getMessage());
//		  }

		
		
		//////
		
		tokenResponse.toString();
		User existingUser = userService.getByToken(credential.getAccessToken());
		
		//If new user, it does registration
		if (existingUser==null)
			userService.create(user);
		
		request.getSession().setAttribute("userToken",EncryptUtils.base64encode(user.getToken()));
		
		return new ModelAndView("redirect:/controlpanel/home/");
	}

}
