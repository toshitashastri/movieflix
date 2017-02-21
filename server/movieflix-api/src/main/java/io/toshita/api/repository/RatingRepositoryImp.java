package io.toshita.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.toshita.api.entity.Rating;
@Repository
public class RatingRepositoryImp implements RatingRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Rating> findAll() {
		TypedQuery<Rating> query = em.createNamedQuery("Rating.findAll", Rating.class);
		return query.getResultList();
	}

	@Override
	public Rating findOne(String id) {
		return em.find(Rating.class, id);
	}

	@Override
	public Rating create(Rating rt) {
		em.persist(rt);
		return rt;
	}

	@Override
	public void delete(Rating rt) {

		em.remove(rt);

	}

	@Override
	public double findRating( String movId) {
		TypedQuery<Double> query = em.createNamedQuery("Rating.findRating", Double.class);
		query.setParameter("rMovie", movId);
		return query.getSingleResult();

	}

}
