package io.toshita.api.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.toshita.api.entity.User;
import io.toshita.api.service.UserService;

@CrossOrigin("http://localhost:4000")
@RestController
@RequestMapping(value="users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "findOne/{id}")
	public User findOne(@PathVariable("id") String id){
		return service.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "{email}/findByEmail")
	public User findByEmail(@PathVariable("email") String email){
		return service.findByEmail(email);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public User create(@RequestBody User usr){
		return service.create(usr);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public User update(@PathVariable("id") String id, @RequestBody User usr){
		return service.update(id, usr);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void delete(@PathVariable("id") String id){
		service.delete(id);
	}
	
	@RequestMapping(method = RequestMethod.GET,path={"/{email}/{password}"})
	public Boolean auth(@PathVariable("email") String email, @PathVariable("password") String password) {
		
    	return service.auth(email, password);
	}

}
