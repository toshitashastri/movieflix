package io.toshita.api.service;


import java.util.List;

import io.toshita.api.entity.Comment;

public interface CommentService {

	public List<Comment> findAll();
	
	public List<Comment> findById(String movieId);
	public Comment findOne(String id);	
	public Comment create(String movieId, String comment);
	
	public void delete( String id);
}
