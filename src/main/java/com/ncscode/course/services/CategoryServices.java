package com.ncscode.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncscode.course.entities.Category;
import com.ncscode.course.repositories.CategoryRepository;

@Service
public class CategoryServices {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
	public Category findById(Integer id){
		return categoryRepository.findById(id).get();
	}
	
}
