package io.toshita.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.toshita.api.entity.Rating;
import io.toshita.api.exception.EntityNotFoundException;
import io.toshita.api.repository.RatingRepository;

@Service
public class RatingServiceImplement implements RatingService {

	@Autowired
	private RatingRepository repository;
	
	@Override
	@Transactional(readOnly=true)
	public List<Rating> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Rating findOne(String id) {
		Rating rt=repository.findOne(id);
		if(rt==null){
			throw new EntityNotFoundException("Rating cannot be found");
		}
		return rt;
	}

	@Override
	@Transactional
	public Rating create(Rating rt) {
		return repository.create(rt);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Rating rt=repository.findOne(id);
		if(rt==null){
			throw new EntityNotFoundException(" Rating not found ");
		}
		repository.delete(rt);
		
	}

	@Override
	@Transactional(readOnly=true)
	public double findRating( String movId) {
		return repository.findRating(movId);
		
	}

}
