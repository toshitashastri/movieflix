package io.toshita.api.repository;

import java.util.List;

import io.toshita.api.entity.Movie;

public interface MovieRepository {
	public List<Movie> findAll();
	public  List<Movie> findByTypeMovie();
	public  List<Movie> findByTypeSeries();
	public  List<Movie> findByYear(String year);
	public  List<Movie> findByGenre(String genre);
	public Movie findOne(String id);
	public Movie create(Movie mov);
	public Movie update(Movie mov);
	public void delete(Movie mov);
	public List<Movie> findByTitle(String title);
	public List<Movie> sortByImdbRating();
	public  List<Movie> sortByYear();
	public  List<Movie> sortByImdbVotes();
	public  List<Movie> getTopRatedMovies(String type);
}
