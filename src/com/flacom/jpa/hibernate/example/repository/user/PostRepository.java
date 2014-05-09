package com.flacom.jpa.hibernate.example.repository.user;


import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.NonUniqueResultException;

import org.springframework.stereotype.Repository;

import com.flacom.jpa.hibernate.example.domain.entity.Post;
import com.flacom.jpa.hibernate.example.domain.entity.User;
import com.flacom.jpa.hibernate.example.repository.AbstractRepository;

@Repository("postRepository")
public class PostRepository extends AbstractRepository<Post> {
    
	@SuppressWarnings("unchecked")
    public List<Post> getAll() {
        
        return entityManager.createQuery("SELECT p FROM Post p ORDER BY p.date desc").setMaxResults(10).getResultList();
        
    }
	
	@SuppressWarnings("unchecked")
    public List<Post> getAllByUser(long idUser) {
        
        return entityManager.createQuery("SELECT p FROM Post p WHERE (p.user.id = :idauthor) order by p.date desc").setParameter("idauthor", idUser).getResultList();
        
    }
	
    public Post getLastPostByUser(long idUser, Date date) {

    Date startdate = new GregorianCalendar(2014, 01, 01).getTime();
    
	List results = entityManager.createQuery("SELECT p FROM Post p WHERE (p.user.id = :idauthor) and (p.date BETWEEN :startdate AND :enddate) order by date desc")
    		.setParameter("startdate", startdate )
    		.setParameter("enddate", date)
    		.setParameter("idauthor", idUser).setMaxResults(10)
    		.getResultList();
	    
		if (results.isEmpty()) 
	    	return null;
	    else 
    		return (Post)results.get(0);
        
    }
	
	@SuppressWarnings("unchecked")
    public List<Post> getLastestPostsByUser(long idUser, Date date) {
		
		Date startdate = new GregorianCalendar(2014, 01, 01).getTime();

        return entityManager.createQuery("SELECT p FROM Post p WHERE (p.user.id = :idauthor) and (p.date BETWEEN :startdate AND :enddate) order by date desc")
        		.setParameter("startdate", startdate )
        		.setParameter("enddate", date)
        		.setParameter("idauthor", idUser).setMaxResults(10)
        		.getResultList();
        
    }
	
    public Post getById(int id) {
        
        List results = entityManager.createQuery("SELECT p FROM Post p  WHERE p.idpost = :id").setParameter("id", id).getResultList();
	    
		if (results.isEmpty()) 
	    	return null;
	    else 
	    	return (Post)results.get(0);
    }
}
