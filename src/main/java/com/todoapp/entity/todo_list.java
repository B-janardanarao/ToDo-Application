package com.todoapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class todo_list {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int SerialNo;
	private String TaskName;
	private String Status;
	public int getSerialNo() {
		return SerialNo;
	}
	public void setSerialNo(int serialNo) {
		SerialNo = serialNo;
	}
	public String getTaskName() {
		return TaskName;
	}
	public void setTaskName(String taskName) {
		TaskName = taskName;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public todo_list(int serialNo, String taskName, String status) {
		super();
		SerialNo = serialNo;
		TaskName = taskName;
		Status = status;
	}
	public todo_list() {
		super();
	}
	
	
}
