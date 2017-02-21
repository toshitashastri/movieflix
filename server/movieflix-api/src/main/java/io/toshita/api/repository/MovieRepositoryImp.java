package io.toshita.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.toshita.api.entity.Movie;

@Repository
public class MovieRepositoryImp implements MovieRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();
	}

	@Override
	public  List<Movie> findByTypeMovie() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByTypeMovie", Movie.class);
		return query.getResultList();
	
	}
	@Override
	public  List<Movie> findByTypeSeries() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByTypeSeries", Movie.class);
		return query.getResultList();
	
	}

	@Override
	public  List<Movie> findByYear(String year) {	
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByYear", Movie.class);
		query.setParameter("pYear", year);
		return query.getResultList();
			
	}

	@Override
	public  List<Movie> findByGenre(String genre) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByGenre", Movie.class);
		query.setParameter("pGenre","%"+ genre+"%");
		List<Movie> movies = query.getResultList();
			return movies;
		
	}

	@Override
	public Movie findOne(String id) {
		return em.find(Movie.class, id);
	}

	@Override
	public Movie create(Movie mov) {
		em.persist(mov);
		return mov;
	}

	@Override
	public Movie update(Movie mov) {

		return em.merge(mov);
	}

	@Override
	public void delete(Movie mov) {

		em.remove(mov);

	}

	@Override
	public List<Movie> findByTitle(String title) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByTitle", Movie.class);
		query.setParameter("pTitle", title);
		List<Movie> movies = query.getResultList();
		if(movies!=null && movies.size()==1){
			return movies;
		}
		else
			return null;
		}

	@Override
	public List<Movie> sortByImdbRating() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortByImdbRating", Movie.class);
		List<Movie> movies = query.getResultList();
		return movies;
	}

	@Override
	public List<Movie> sortByYear() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortByYear", Movie.class);
		List<Movie> movies = query.getResultList();
			return movies;
	}

	@Override
	public List<Movie> sortByImdbVotes() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortByImdbVotes", Movie.class);
		List<Movie> movies = query.getResultList();
			return movies;
		
	}

	@Override
	public List<Movie> getTopRatedMovies(String type) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.getTopRated", Movie.class);
		query.setParameter("mType", type);
		List<Movie> movies = query.getResultList();
			return movies;
	}

	
}
