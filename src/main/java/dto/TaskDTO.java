package dto;

import com.CrudForTraining.demo.entities.Task;
import com.CrudForTraining.demo.enums.TaskStatus;

public class TaskDTO {
	
	private Long id;
	private String title;
	private String description;
	private TaskStatus status;
	
	private UserDTO user;

	public TaskDTO() {
	}

	public TaskDTO(Long id, String title, String description, TaskStatus status, UserDTO user) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
		this.user = user;
	}
	
	public TaskDTO(Task task) {
		id = task.getId();
		title = task.getTitle();
		description = task.getDescription();
		status = task.getStatus();
		user = new UserDTO(task.getUser());
	}
	
	
	

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public UserDTO getUser() {
		return user;
	}
	
	
	
	
	
	
	
	

}
