package io.toshita.api.repository;

import java.util.List;

import io.toshita.api.entity.User;

public interface UserRepository {

	public List<User> findAll();
	public User findOne(String id);
	public User create(User usr);
	public User update(User usr);
	public void delete(User usr);
	public User findByEmail(String email);
	public User auth(String email,String password);
}
