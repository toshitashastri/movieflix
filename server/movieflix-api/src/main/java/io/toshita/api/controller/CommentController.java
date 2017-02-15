package io.toshita.api.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.toshita.api.entity.Comment;
import io.toshita.api.service.CommentService;

@RestController
@RequestMapping(value="comments")
public class CommentController {

	@Autowired
	private CommentService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Comment> findAll(){
		return service.findAll();
	}
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public Comment findOne(@PathVariable("id") String id){
		return service.findOne(id);
	}
		
	@RequestMapping(method = RequestMethod.POST)
	public Comment create(@RequestBody Comment cmt){
		return service.create(cmt);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void delete(@PathVariable("id") String id){
		service.delete(id);
	}
	
	
}
