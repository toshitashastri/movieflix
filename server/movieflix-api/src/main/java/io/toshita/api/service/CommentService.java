package io.toshita.api.service;

import java.util.List;

import io.toshita.api.entity.Comment;

public interface CommentService {

	public List<Comment> findAll();
	
	public Comment findOne(String id);
		
	public Comment create(Comment cmt);
	
	public void delete( String id);
}
