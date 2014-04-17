package com.flacom.jpa.hibernate.example.service.user;

import java.util.Date;
import java.util.List;

import com.flacom.jpa.hibernate.example.domain.entity.Post;
import com.flacom.jpa.hibernate.example.domain.entity.User;

public interface UserService {
    
   List<User> getAll() throws Exception;
   
   User create(User user) throws Exception;
   
   User getByToken(String token) throws Exception;
   
   User getByName(String username) throws Exception;
   
   List<Post> getPostsByUser(long idUser)throws Exception;
   
   List<Post> getLastestPostsByUser(long idUser, Date date)throws Exception;
   
   Post getLastPostByUser(long idUser, Date date)throws Exception;
      
   Post getPostByUser(long idUser, int idpost)throws Exception;
   
   Post create (Post post) throws Exception;
   
   Post update (Post post) throws Exception;
   
   void remove (int idpost, long iduser) throws Exception;
}
