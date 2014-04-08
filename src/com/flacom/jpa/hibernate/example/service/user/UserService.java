package com.flacom.jpa.hibernate.example.service.user;

import java.util.List;

import com.flacom.jpa.hibernate.example.domain.user.Post;
import com.flacom.jpa.hibernate.example.domain.user.User;

public interface UserService {
    
   List<User> getAll() throws Exception;
   
   User create(User user) throws Exception;
   
   User getByToken(String token) throws Exception;
   
   List<Post> getPostsByUser(long idUser)throws Exception;
   
   Post getPostByUser(long idUser, int idpost)throws Exception;
   
   Post create (Post post) throws Exception;
   
   Post edit (Post post) throws Exception;
   
   void remove (Post post) throws Exception;
}
