package io.toshita.api.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.toshita.api.entity.Movie;
import io.toshita.api.exception.BadRequestException;
import io.toshita.api.exception.EntityNotFoundException;
import io.toshita.api.repository.MovieRepository;

@Service
public class MovieServiceImplement implements MovieService {

	private MovieRepository repository;
	
	@Override
	@Transactional(readOnly=true)
	public List<Movie> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Movie> findByType(String type) {

		List<Movie> current =repository.findByType(type);
		if(current!=null){
			throw new EntityNotFoundException("Entity not found");
		}
		return current;
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Movie> findByYear(int year) {
		
		List<Movie> current =repository.findByYear(year);
		if(current!=null){
			throw new EntityNotFoundException("Entity not found");
		}
		return current;
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Movie> findByGenre( String genre) {
		List<Movie> current =repository.findByGenre(genre);
		if(current!=null){
			throw new EntityNotFoundException("Entity not found");
		}
		return current;
	}

	@Override
	@Transactional(readOnly=true)
	public Movie findOne(String id) {

		Movie mov= repository.findOne(id);
		if(mov==null){
			throw new EntityNotFoundException("Entity not found");
		}
		return mov;
	}

	@Override	
	@Transactional
	public Movie create(Movie mov) {

		Movie current=repository.findByTitle(mov.getTitle());
		if(current!=null){
			throw new BadRequestException("Entity with this title already exists");
		}
		return repository.create(mov);
	}

	@Override
	@Transactional
	public Movie update(String id, Movie mov) {	
		Movie current=repository.findOne(id);
		if(current==null){
			throw new EntityNotFoundException(" Entity not found ");
		}
		return repository.update( mov);

	}

	@Override
	@Transactional
	public void delete(String id) {
		Movie mov=repository.findOne(id);
		if(mov==null){
			throw new EntityNotFoundException(" Entity not found ");
		}
		repository.delete(mov);

	}

	@Override
	public List<Movie> sortByImdbRating() {
		
		return repository.sortByImdbRating();
	}

	@Override
	public List<Movie> sortByYear() {
		return repository.sortByYear();
	}

	@Override
	public List<Movie> sortByImdbVotes() {
		return repository.sortByImdbVotes();
	}

	@Override
	public List<Movie> getTopRatedMovies() {
		return repository.getTopRatedMovies();
	}

	@Override
	public List<Movie> getTopRatedSeries() {
		return repository.getTopRatedSeries();
	}

	@Override
	@Transactional(readOnly=true)
	public Movie findByTitle(String title) {

		Movie mov= repository.findByTitle(title);
		if(mov==null){
			throw new EntityNotFoundException("Entity with this title does not exist");
		}
		return mov;
	}

}
