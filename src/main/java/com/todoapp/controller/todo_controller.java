package com.todoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.todoapp.entity.todo_list;
import com.todoapp.service.todo_service;

@Controller
public class todo_controller {


	@Autowired
	private todo_service service;
	
	
	@GetMapping("/")
	public String home() {
		return "bookList";
	}
	
	@GetMapping("/todolist_register")
	public String todo_listRegister() {
		return "todolist";
	}
	
	@GetMapping("/available_books")
	public ModelAndView getAlllist() {
	    List<todo_list> list = service.getAlltodo_list();
	    ModelAndView m = new ModelAndView();
	    m.setViewName("bookList");
	    m.addObject("tasks", list); // Make sure to use the correct attribute name here
	    return m;
	}

	
	@PostMapping("/save")
	public String addtodo_list(@ModelAttribute todo_list b) {
	    service.save(b);
	    return "redirect:/available_books"; // This should fetch and display the updated task list
	}

	
	
	
	
	@RequestMapping("/edittodo_list/{id}")
	public String edittodo_list(@PathVariable("id") int id, Model model) {
	    todo_list b = service.gettodo_listById(id);
	    if (b == null) {
	        // Handle case where the item is not found
	        model.addAttribute("error", "Task not found");
	        return "errorPage"; // Redirect to a specific error page if needed
	    }
	    model.addAttribute("list", b);
	    return "bookEdit";
	}

	@RequestMapping("/deletetodo_list/{id}")
	public String deletetodo_list(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/available_books";
	}
}
