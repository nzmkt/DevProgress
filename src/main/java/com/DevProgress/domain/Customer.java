package com.DevProgress.domain;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data    // すべてのフィールドに対するsetter/getterメソッド、equalsメソッド、hashCodeメソッド、toStringメソッドが生成される
@AllArgsConstructor  // すべてのフィールドを初期化する引数を持つコンストラクタが生成される
@NoArgsConstructor  // 引数なしのデフォルトコンストラクタが生成される
public class Customer {
    private Integer id;
    private String name;
    private String email;
}