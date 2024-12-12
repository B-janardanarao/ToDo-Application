package com.todoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoapp.entity.todo_list;
import com.todoapp.repository.todorepo;

@Service
public class todo_service {

	@Autowired
	private todorepo repo;
	
	
	
	public void save(todo_list b) {
	    System.out.println("Saving task: " + b);
	    repo.save(b);
	}

	
	public List<todo_list> getAlltodo_list(){
		return repo.findAll();
	}
	
	public todo_list gettodo_listById(int id) {
		return repo.findById(id).get();
	}
	public void deleteById(int id) {
		repo.deleteById(id);
	}
}
