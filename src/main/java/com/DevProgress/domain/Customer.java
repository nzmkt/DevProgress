package com.DevProgress.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity		// JPA: エンティティクラスであることを記すアノテーション
@Table(name="customer")	// JPA: どのテーブルとマッピングするのか指定
@Data    // すべてのフィールドに対するsetter/getterメソッド、equalsメソッド、hashCodeメソッド、toStringメソッドが生成される
@AllArgsConstructor  // すべてのフィールドを初期化する引数を持つコンストラクタが生成される
@NoArgsConstructor  // 引数なしのデフォルトコンストラクタが生成される
public class Customer {
	
	@Id	// JPA: フィールドidがエンティティの主キー
	@GeneratedValue	// JPA: 自動採番する主キー
	private Integer id;
	
	@Column(nullable=false)	// nullでの更新を抑制
	private String name;
	
	@Column(nullable=false)
    private String email;
}