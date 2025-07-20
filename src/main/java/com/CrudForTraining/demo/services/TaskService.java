package com.CrudForTraining.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CrudForTraining.demo.entities.Task;
import com.CrudForTraining.demo.entities.User;
import com.CrudForTraining.demo.repositories.TaskRepository;
import com.CrudForTraining.demo.repositories.UserRepository;

import dto.TaskDTO;
import dto.UserDTO;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Transactional(readOnly = true)
	public List<TaskDTO> findAll(){
		List<Task> result= repository.findAll();
		return result.stream().map(x-> new TaskDTO(x)).collect(Collectors.toList());

	}
	
	@Transactional(readOnly = true)
	public List<TaskDTO> taskByUserId(Long id) {
		User entity= userRepository.getReferenceById(id);
		return entity.getTasks().stream().map(x-> new TaskDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public TaskDTO newTask(TaskDTO dto) {
		Task entity= new Task();
		entity.setDescription(dto.getDescription());
		entity.setTitle(dto.getTitle());
		entity.setTitle(dto.getTitle());
		entity.setUser(userRepository.getReferenceById(dto.getUser().getId()));;
		entity=repository.save(entity);
		return new TaskDTO(entity);
	}
	
	

}
