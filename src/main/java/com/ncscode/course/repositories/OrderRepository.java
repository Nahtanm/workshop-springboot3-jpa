package com.ncscode.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncscode.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
