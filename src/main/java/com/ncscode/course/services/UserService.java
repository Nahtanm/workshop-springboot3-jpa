package com.ncscode.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ncscode.course.entities.User;
import com.ncscode.course.repositories.UserRepository;
import com.ncscode.course.services.exceptions.DatabaseExcepiton;
import com.ncscode.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Integer id) {
		return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return userRepository.save(obj);
	}
	
	public void delete(Integer id) {
		try {
			userRepository.deleteById(id);			
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseExcepiton(e.getMessage());
		}
	}
	
	public User update(Integer id, User user) {
		try {
			User entity = userRepository.getReferenceById(id);
			updateData(entity, user);
			return userRepository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(e.getMessage());
		}
	}

	public void updateData(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
	}
	
}