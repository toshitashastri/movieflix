package io.toshita.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.toshita.api.entity.Comment;
import io.toshita.api.exception.EntityNotFoundException;
import io.toshita.api.repository.CommentRepository;

@Service
public class CommentServiceImplement implements CommentService {

	@Autowired
	private CommentRepository repository;
	
	@Override
	@Transactional(readOnly=true)
	public List<Comment> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Comment findOne(String id) {
		Comment cmt=repository.findOne(id);
		if(cmt==null){
			throw new EntityNotFoundException("Comment could not be found");
		}
		return cmt;
	}

	@Override
	@Transactional
	public Comment create(Comment cmt) {
		return repository.create(cmt);
	}

	@Override
	@Transactional
	public void delete(String id) {

		Comment cmt=repository.findOne(id);
		if(cmt==null){
			throw new EntityNotFoundException("Comment does not exist");
		}
		repository.delete(cmt);
	}

}
