package com.example.todo.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.Todo;
import com.example.todo.repository.TodoRepository;

@Service
public class TodoService implements ITodoService {
	
	
	@Autowired
	TodoRepository todoRepo;
	
	 private static List<Todo> todos=new ArrayList<>(); // In-memory database
	 

	    public List<Todo> findAll() { // Business Logic
	        return todoRepo.findAll();
	    }

	    public Todo findById(int id) {
	     return todoRepo.findById(id).get();
	    }

		public void addTodo(Todo todo) {
		   todoRepo.save(todo);
		}

		public void deleteById(int id) {
			todoRepo.deleteById(id);
			
		}

		public void updateById(int id, Todo newTodo) {
			  Todo todo1=findById(id);// step 1

		        todo1.setId(newTodo.getId());
		        todo1.setTitle(newTodo.getTitle());
		        todo1.setStatus(newTodo.isStatus());
		}
}
