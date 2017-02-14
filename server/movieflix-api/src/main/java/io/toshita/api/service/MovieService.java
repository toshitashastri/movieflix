package io.toshita.api.service;


import java.util.List;

import io.toshita.api.entity.Movie;

public interface MovieService {
	
	public List<Movie> findAll();
	public List<Movie> findByTypeMovie();
	public List<Movie> findByTypeSeries();
	public List<Movie> findByYear( String year);
	public List<Movie> findByGenre(String type, String genre);
	public Movie findOne(String id);
	public Movie create(Movie mov);
	public Movie update(String id,Movie mov);
	public void delete(String id);
	public List<Movie> sortByImdbRating();
	public List<Movie> sortByYear();
	public List<Movie> sortByImdbVotes();
	public List<Movie> getTopRatedMovies(String type);
	public Movie findByTitle(String title);

}
