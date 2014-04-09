package com.flacom.jpa.hibernate.example.repository.user;


import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.flacom.jpa.hibernate.example.domain.entity.Post;
import com.flacom.jpa.hibernate.example.repository.AbstractRepository;

@Repository("postRepository")
public class PostRepository extends AbstractRepository<Post> {
    
	@SuppressWarnings("unchecked")
    public List<Post> getAll() {
        
        return entityManager.createQuery("SELECT p FROM Post p ORDER BY p.date").getResultList();
        
    }
	
	@SuppressWarnings("unchecked")
    public List<Post> getAllByUser(long idUser) {
        
        return entityManager.createQuery("SELECT p FROM Post p ORDER BY p.date WHERE p.idauthor = :idUser").setParameter("idUser", idUser).getResultList();
        
    }
	
    public Post getLastPostByUser(long idUser, Date date) {
        return (Post) entityManager.createQuery("SELECT p FROM Post p WHERE (p.user.id = :idauthor)")
        		//.setParameter("date", date)
        		.setParameter("idauthor", idUser)
        		.getSingleResult();
        
    }
	
	@SuppressWarnings("unchecked")
    public List<Post> getLastestPostsByUser(long idUser, Date date) {
        return entityManager.createQuery("SELECT p FROM Post p WHERE (p.user.id = :idauthor)")
        		//.setParameter("date", date)
        		.setParameter("idauthor", idUser)
        		.getResultList();
        
    }
	
    public Post getById(int id) {
        
        return (Post) entityManager.createQuery("SELECT p FROM Post p  WHERE p.idpost = :id").setParameter("id", id).getSingleResult();
        
    }
}
