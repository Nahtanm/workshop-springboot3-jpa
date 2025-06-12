package com.ncscode.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncscode.course.entities.Product;
import com.ncscode.course.services.ProductServices;

@RestController
@RequestMapping(value = "/products")
public class ProductResources {

	@Autowired
	private ProductServices productServices;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		return ResponseEntity.ok().body(productServices.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Integer id){
		return ResponseEntity.ok().body(productServices.findById(id));
	}
	
}
