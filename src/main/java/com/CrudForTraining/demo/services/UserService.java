package com.CrudForTraining.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CrudForTraining.demo.entities.User;
import com.CrudForTraining.demo.repositories.UserRepository;

import dto.TaskDTO;
import dto.UserDTO;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public List<UserDTO> findAll(){
		List<User> result= repository.findAll();
		return result.stream().map(x-> new UserDTO(x)).collect(Collectors.toList());

	}
	
	@Transactional
	public UserDTO newUser(UserDTO dto) {
		User entity= new User();
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity=repository.save(entity);
		return new UserDTO(entity);
	}

}
