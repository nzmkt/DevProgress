package com.DevProgress.form;

import java.util.List;

import com.DevProgress.TodoItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data    // すべてのフィールドに対するsetter/getterメソッド、equalsメソッド、hashCodeメソッド、toStringメソッドが生成される
@AllArgsConstructor  // すべてのフィールドを初期化する引数を持つコンストラクタが生成される
@NoArgsConstructor  // 引数なしのデフォルトコンストラクタが生成される
public class TodoItemForm{
	private boolean isDone;
	private List<TodoItem> todoItems;
	
	
}