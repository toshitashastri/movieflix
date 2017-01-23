package io.toshita.api.repository;

import java.util.List;

import io.toshita.api.entity.Comment;

public interface CommentRepository {
	
	public List<Comment> findAll();
	
	public Comment findOne(String id);
		
	public Comment create(Comment cmt);
	
	public void delete( Comment cmt);
}
