package com.flacom.jpa.hibernate.example.service.implementation.user;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flacom.jpa.hibernate.example.domain.entity.Post;
import com.flacom.jpa.hibernate.example.domain.entity.User;
import com.flacom.jpa.hibernate.example.repository.user.PostRepository;
import com.flacom.jpa.hibernate.example.repository.user.UserRepository;
import com.flacom.jpa.hibernate.example.service.user.UserService;

/**
 * provides services for user.
 *
 */
@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
	
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PostRepository postRepository;
    
    public List<User> getAll() {

        return userRepository.getAll();
    }
    
    @Transactional(readOnly = false)
    public User create(User user) throws ParseException {

    	return userRepository.merge(user);
        
    }
    
   public User getByToken(String token) throws Exception
   {
	   return userRepository.getByToken(token);
   }
   
   public User getByName(String username) throws Exception
   {
	   return userRepository.getByName(username);
   }
   
   public List<Post> getPostsByUser(long idUser)throws Exception
   {
	   return postRepository.getAllByUser(idUser);
   }
   
   public List<Post> getLastestPostsByUser(long idUser, Date date)throws Exception
   {
	   return postRepository.getLastestPostsByUser(idUser, date);
   }
   
   public Post getLastPostByUser(long idUser, Date date)throws Exception
   {
	   return postRepository.getLastPostByUser(idUser, date);
   }
   
   public Post getPostByUser(long idUser, int idPost)throws Exception
   {
	   Post post = postRepository.getById(idPost);
	   if (post.getIdAuthor() == idUser)
		   return post;
	   else
		   return null;
   }
   
   @Transactional(readOnly = false)
   public Post create (Post post) throws Exception
   {
	   return postRepository.merge(post);
   }
   
   @Transactional(readOnly = false)
   public Post edit (Post post) throws Exception
   {
	   return postRepository.merge(post);
   }
   
   @Transactional(readOnly = false)
   public void remove (Post post) throws Exception
   {
	   postRepository.remove(post);
   
   }
}
