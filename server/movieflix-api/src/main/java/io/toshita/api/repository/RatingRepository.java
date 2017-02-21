package io.toshita.api.repository;

import java.util.List;

import io.toshita.api.entity.Rating;

public interface RatingRepository {

	public List<Rating> findAll();	
	
	public Rating findOne( String id);
	
	public Rating create(Rating rt);
	
	public void delete(Rating rt);
	
	public double findRating( String movId);
}
