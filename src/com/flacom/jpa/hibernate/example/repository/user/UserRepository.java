package com.flacom.jpa.hibernate.example.repository.user;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;

import org.springframework.stereotype.Repository;

import com.flacom.jpa.hibernate.example.domain.entity.User;
import com.flacom.jpa.hibernate.example.repository.AbstractRepository;

@Repository("userRepository")
public class UserRepository extends AbstractRepository<User> {
	
   
	@SuppressWarnings("unchecked")
    public List<User> getAll() {
        
        return entityManager.createQuery("SELECT u FROM User u ORDER BY u.username").getResultList();
        
    }
	
	public User getByToken(String token) {

		List results = entityManager.createQuery("SELECT u FROM User u where token = :token").setParameter("token",  token).getResultList();
	    
		if (results.isEmpty()) 
	    	return null;
	    else 
	    	if (results.size() == 1) 
	    		return (User)results.get(0);
	   
	    throw new NonUniqueResultException();

    }
	
   public User getByName(String username) {
        
	   List results = entityManager.createQuery("SELECT u FROM User u  where username = :username").setParameter("username",  username).getResultList();
	    
		if (results.isEmpty()) 
	    	return null;
	    else 
	    	if (results.size() == 1) 
	    		return (User)results.get(0);
	   
	    throw new NonUniqueResultException();
    }
	
}
