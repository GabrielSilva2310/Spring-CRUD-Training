package com.CrudForTraining.demo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.CrudForTraining.demo.services.UserService;

import dto.UserDTO;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	
	@Autowired
	private UserService service;
	
	@GetMapping()
	public ResponseEntity<List<UserDTO>> findAll(){
		List<UserDTO> list=service.findAll();
		return ResponseEntity.ok(list);
		
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> newUser(@RequestBody UserDTO dto){
		dto=service.newUser(dto);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

}
