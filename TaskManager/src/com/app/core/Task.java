package com.app.core;

import java.time.LocalDate;
import java.util.Objects;

public class Task {
	private int taskId;
	private static int id;
	static {
		id=1;
	}
	private String taskName;
	private String description;
	private LocalDate taskDate;
	private Status status;
	private boolean active;
	
	//constructors
	public Task() {
		super();
	}
	
	public Task(String taskName, String description, LocalDate taskDate) {
		super();
		this.taskId = id;
		id++;
		this.taskName = taskName;
		this.description = description;
		this.taskDate = taskDate;
		this.status=status.PENDING;
		this.active=true;
	}
	

	public Task(String taskName, String description, LocalDate taskDate, Status status, boolean active) {
		super();
		this.taskId = id;
		id++;
		this.taskName = taskName;
		this.description = description;
		this.taskDate = taskDate;
		this.status = status;
		this.active = active;
	}

	//getters and setters
	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(LocalDate taskDate) {
		this.taskDate = taskDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	//toString
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", description=" + description + ", taskDate="
				+ taskDate + ", status=" + status + ", active=" + active + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(taskId);
	}

	
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Task)
		{
			Task t=(Task)o;
			return this.taskId==(t.taskId);
		}
		return false;
	}

	
}
