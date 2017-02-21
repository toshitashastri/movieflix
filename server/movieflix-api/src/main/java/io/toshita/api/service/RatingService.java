package io.toshita.api.service;

import java.util.List;

import io.toshita.api.entity.Rating;

public interface RatingService {

	public List<Rating> findAll();	
	
	public Rating findOne( String id);
	
	public Rating create(Rating rt);
	
	public void delete(String id);
	
	public double findRating( String movId);
}
