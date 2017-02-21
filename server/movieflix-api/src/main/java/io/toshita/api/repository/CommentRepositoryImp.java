package io.toshita.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.toshita.api.entity.Comment;

@Repository
public class CommentRepositoryImp implements CommentRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Comment> findAll() {
		TypedQuery<Comment> query = em.createNamedQuery("Comment.findAll", Comment.class);
		return query.getResultList();
	}
	@Override
	public Comment findOne(String id) {
		return em.find(Comment.class, id);
		}
	@Override
	public List<Comment> findById(String movieId) {
		TypedQuery<Comment> query = em.createNamedQuery("Comment.findByMovieId", Comment.class);
		query.setParameter("pmovieId", movieId);
		List<Comment> reviews = query.getResultList();
		
			return reviews;
		
		}

	@Override
	public Comment create(Comment cmt) {
		em.persist(cmt);
		return cmt;
	}

	@Override
	public void delete(Comment cmt) {

		em.remove(cmt);
	}

}
