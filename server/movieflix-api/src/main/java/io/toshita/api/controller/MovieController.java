package io.toshita.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.toshita.api.entity.Movie;
import io.toshita.api.service.MovieService;

@RestController
@RequestMapping(value="movies")
public class MovieController {

	@Autowired
	private MovieService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Movie> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{type}")
	public List<Movie> findByType(@PathVariable("type") String type){
		return service.findByType(type);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{year}")
	public List<Movie> findByYear(@PathVariable("year") int year){
		return service.findByYear(year);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{genre}")
	public List<Movie> findByGenre(@PathVariable("genre") String genre){
		return service.findByGenre(genre);
	}
	@RequestMapping(method = RequestMethod.GET, value = "/{imdbRating}")
	public List<Movie> sortByImdbRating() {
		return service.sortByImdbRating();
	}
	@RequestMapping(method = RequestMethod.GET, value = "/{year}")
	public List<Movie> sortByYear() {
		return service.sortByYear();
	}
	@RequestMapping(method = RequestMethod.GET, value = "/{imdbVotes}")
	public List<Movie> sortByImdbVotes(){
		return service.sortByImdbVotes();
	}
	@RequestMapping(method=RequestMethod.GET, value="/{topRatedMovies}")
	public List<Movie> getTopRatedMovies() {
		return service.getTopRatedMovies();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{topRatedSeries}" )
	public List<Movie> getTopRatedSeries() {
		return service.getTopRatedSeries();
	}
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public Movie findOne(@PathVariable("id") String id){
		return service.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{title}")
	public Movie findByTitle(@PathVariable("title") String title){
		return service.findByTitle(title);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Movie create(@RequestBody Movie mov){
		return service.create(mov);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public Movie update(@PathVariable("id") String id, @RequestBody Movie mov){
		return service.update(id, mov);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void delete(@PathVariable("id") String id){
		service.delete(id);
	}
	
}
