package com.ncscode.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncscode.course.entities.Order;
import com.ncscode.course.repositories.OrderRepository;

@Service
public class OrderServices {

	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> findAll(){
		return orderRepository.findAll();
	}
	
	public Order findById(Integer id) {
		return orderRepository.findById(id).get();
	}
	
}
