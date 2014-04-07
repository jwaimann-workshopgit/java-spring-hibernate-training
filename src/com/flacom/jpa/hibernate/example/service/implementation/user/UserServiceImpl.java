package com.flacom.jpa.hibernate.example.service.implementation.user;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flacom.jpa.hibernate.example.domain.user.User;
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
    
    public List<User> getAll() {

        return userRepository.getAll();
    }
    
    @Transactional(readOnly = false)
    public User create(User user) throws ParseException {

    	return userRepository.merge(user);
        
    }
    
}
