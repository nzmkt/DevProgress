package com.DevProgress.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DevProgress.TodoItem;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
	public List<TodoItem> findByDoneOrderByIdAsc(boolean done);
}