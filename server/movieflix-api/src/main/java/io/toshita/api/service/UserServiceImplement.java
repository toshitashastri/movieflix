package io.toshita.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.toshita.api.entity.User;
import io.toshita.api.exception.BadRequestException;
import io.toshita.api.exception.EntityNotFoundException;
import io.toshita.api.repository.UserRepository;

@Service
public class UserServiceImplement implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Override
	@Transactional(readOnly=true)
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public User findOne(String id) {
		User usr=repository.findOne(id);
		if(usr==null){
			throw new EntityNotFoundException(" User not found ");
		}
		return usr;
	}

	@Override
	@Transactional
	public User create(User usr) {
		User current=repository.findByEmail(usr.getEmail());
		if(current!=null){
			throw new BadRequestException(" User with this email already exists ");
		}
		return repository.create(usr);
	}

	@Override
	@Transactional
	public User update(String id, User usr) {
		User current=repository.findOne(id);
		if(current==null){
			throw new EntityNotFoundException(" User not found ");
		}
		return repository.update(usr);
	}

	@Override
	@Transactional
	public void delete(String id) {
		User current=repository.findOne(id);
		if(current==null){
			throw new EntityNotFoundException(" User not found ");
		}
		repository.delete(current);
	}

}
