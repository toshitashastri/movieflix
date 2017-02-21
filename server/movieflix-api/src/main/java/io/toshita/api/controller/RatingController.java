package io.toshita.api.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.toshita.api.entity.Rating;
import io.toshita.api.service.RatingService;

@CrossOrigin("http://localhost:4000")
@RestController
@RequestMapping(value="ratings")
public class RatingController {

	@Autowired
	private RatingService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Rating> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Rating findOne(@PathVariable("id") String id){
		return service.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Rating create(@RequestBody Rating rt){
		return service.create(rt);
	}
	
		
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void delete(@PathVariable("id") String id){
		service.delete(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/avg/{movId}")
	public double findRating(@PathVariable("movId") String movId){
		return service.findRating( movId);
	}
	

}
