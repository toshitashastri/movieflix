package io.toshita.api.service;

import java.util.List;

import io.toshita.api.entity.Movie;

public interface MovieService {
	
	public List<Movie> findAll();
	public List<Movie> findByType(String type);
	public List<Movie> findByYear( int year);
	public List<Movie> findByGenre(String genre);
	public Movie findOne(String id);
	public Movie create(Movie mov);
	public Movie update(String id,Movie mov);
	public void delete(String id);
	public List<Movie> sortByImdbRating();
	public List<Movie> sortByYear();
	public List<Movie> sortByImdbVotes();
	public List<Movie> getTopRatedMovies();
	public List<Movie> getTopRatedSeries();
	public Movie findByTitle(String title);

}
