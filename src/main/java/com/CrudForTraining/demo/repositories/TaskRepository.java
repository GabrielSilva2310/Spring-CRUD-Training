package com.CrudForTraining.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CrudForTraining.demo.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
