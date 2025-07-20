package com.CrudForTraining.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CrudForTraining.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
