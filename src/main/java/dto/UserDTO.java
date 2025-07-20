package dto;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
	
	private Long id;
	private String name;
	private String email;
	
	private List<TaskDTO> tasks= new ArrayList<>();
	
	
	public UserDTO() {
	}

	public UserDTO(Long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public List<TaskDTO> getTasks() {
		return tasks;
	}
	
	
	
	
	
	

}
