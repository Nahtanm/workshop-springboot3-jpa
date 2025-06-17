package com.ncscode.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncscode.course.entities.OrderItem;
import com.ncscode.course.entities.pk.OrderItemPk;

public interface OrderItemRepository extends  JpaRepository<OrderItem, OrderItemPk> {

}
