package com.flacom.jpa.hibernate.example.service.user;

import java.util.List;

import com.flacom.jpa.hibernate.example.domain.user.User;

public interface UserService {
    
   List<User> getAll() throws Exception;
   
   User create(User user) throws Exception;
   
}
