package com.ncscode.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncscode.course.entities.Category;
import com.ncscode.course.services.CategoryServices;

@RestController
@RequestMapping(value = "/categorys")
public class CategoryResources {

	@Autowired
	private CategoryServices categoryServices;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		return ResponseEntity.ok().body(categoryServices.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Integer id){
		return ResponseEntity.ok().body(categoryServices.findById(id));
	}
	
}
