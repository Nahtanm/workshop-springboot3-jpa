package com.ncscode.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncscode.course.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
