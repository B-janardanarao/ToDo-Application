package com.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todoapp.entity.todo_list;

@Repository
public interface todorepo extends JpaRepository<todo_list, Integer>{

}
