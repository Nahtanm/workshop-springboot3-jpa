package com.ncscode.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncscode.course.entities.User;
import com.ncscode.course.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Integer id) {
		return userRepository.findById(id).get();
	}
	
	public User insert(User obj) {
		return userRepository.save(obj);
	}
	
	public void delete(Integer id) {
		userRepository.deleteById(id);
	}
	
	public User update(Integer id, User user) {
		User entity = userRepository.getReferenceById(id);
		updateData(entity, user);
		return userRepository.save(entity);
	}

	public void updateData(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
	}
	
}