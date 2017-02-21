package io.toshita.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.toshita.api.entity.Movie;
import io.toshita.api.service.MovieService;

@CrossOrigin("http://localhost:4000")
@RestController
@RequestMapping(value="movies")
public class MovieController {

	@Autowired
	private MovieService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Movie> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/findByTypeMovie")
	public List<Movie> findByTypeMovie(){
		return service.findByTypeMovie();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/findByTypeSeries")
	public List<Movie> findByTypeSeries(){
		return service.findByTypeSeries();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "findByYear/{year}")
	public List<Movie> findByYear(@PathVariable("year") String year){
		return service.findByYear(year);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "findByGenre/{genre}")
	public List<Movie> findByGenre(@PathVariable("genre") String genre){
		return service.findByGenre(genre);
	}
	@RequestMapping(method = RequestMethod.GET, value = "/sortByImdbRating")
	public List<Movie> sortByImdbRating() {
		return service.sortByImdbRating();
	}
	@RequestMapping(method = RequestMethod.GET, value= "movie/sortByYear")
	public List<Movie> sortByYear() {
		return service.sortByYear();
	}
	@RequestMapping(method = RequestMethod.GET, value = "/sortByVotes")
	public List<Movie> sortByImdbVotes(){
		return service.sortByImdbVotes();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getTopRated/{type}")
	public List<Movie> getTopRatedMovies(@PathVariable("type") String type) {
		return service.getTopRatedMovies(type);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="{id}")
	public Movie findOne(@PathVariable("id") String id){
		return service.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="movie/{title}")
	public List<Movie> findByTitle(@PathVariable("title") String title){
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