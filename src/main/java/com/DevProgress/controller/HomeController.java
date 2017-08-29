package com.DevProgress.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.DevProgress.TodoItem;
import com.DevProgress.form.TodoItemForm;
import com.DevProgress.repository.TodoItemRepository;

@Controller
public class HomeController {
	
	@Autowired
	private TodoItemRepository repository;
	
	@RequestMapping
	public String index(@ModelAttribute TodoItemForm todoItemForm, @RequestParam("isDone")Optional<Boolean> isDone) {
		todoItemForm.setDone(isDone.isPresent() 
				? isDone.get() : false);
		todoItemForm.setTodoItems(this.repository.
				findByDoneOrderByIdAsc(todoItemForm.isDone()));
		return "index";
	}
	
	@RequestMapping(value = "/done", method = RequestMethod.POST)
	public String done(@RequestParam("id") long id) {
		TodoItem item = this.repository.findOne(id);
		item.setDone(true);
		this.repository.save(item);
		return "redirect:/?isDone=false";
	}
	
	@RequestMapping(value = "/restore", method = RequestMethod.POST)
	public String restore(@RequestParam("id") long id) {
		TodoItem item = this.repository.findOne(id);
		item.setDone(false);
		this.repository.save(item);
		return "redirect:/?isDone=true";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String newItem(TodoItem item) {
		item.setDone(false);
		this.repository.save(item);
		return "redirect:/";
	}

	
}