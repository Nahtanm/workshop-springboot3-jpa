package com.ncscode.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncscode.course.entities.Order;
import com.ncscode.course.services.OrderServices;

@RestController
@RequestMapping(value = "/orders")
public class OrderResources {

	@Autowired
	private OrderServices orderServices;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		return ResponseEntity.ok().body(orderServices.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Integer id){
		return ResponseEntity.ok().body(orderServices.findById(id));
	}
	
}
