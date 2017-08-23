package com.DevProgress;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="todoitems")
@Data
@AllArgsConstructor  // すべてのフィールドを初期化する引数を持つコンストラクタが生成される
@NoArgsConstructor  // 引数なしのデフォルトコンストラクタが生成される
public class TodoItem {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	"todoitems_id_seq")
	@SequenceGenerator(name = "todoitems_id_seq", sequenceName = 
	"todoitems_id_seq")
	private Long id;
	private String title;
	private Boolean done;
	

}
