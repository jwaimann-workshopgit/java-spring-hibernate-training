package com.flacom.jpa.hibernate.example.repository.user;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.flacom.jpa.hibernate.example.domain.user.User;
import com.flacom.jpa.hibernate.example.repository.AbstractRepository;

@Repository("userRepository")
public class UserRepository extends AbstractRepository<User> {
    
	@SuppressWarnings("unchecked")
    public List<User> getAll() {
        
        return entityManager.createQuery("SELECT u FROM User u ORDER BY u.username").getResultList();
        
    }
	
	public User getByToken(String token) {
        
        return (User) entityManager.createQuery("SELECT u FROM User u ORDER BY u.username where token = :token").setParameter("token",  token).getSingleResult();
        
    }
	
}
