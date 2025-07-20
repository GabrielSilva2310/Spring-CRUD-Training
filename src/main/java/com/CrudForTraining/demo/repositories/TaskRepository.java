package com.CrudForTraining.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CrudForTraining.demo.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
