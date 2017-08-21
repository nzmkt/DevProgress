package com.DevProgress.repository;

import com.DevProgress.domain.Customer;

import org.springframework.data.jpa.repository.JpaRepository;


	/**
	 *  JpaRepositoryを拡張したインターフェースを定義
	 *  JpaRepositoryを拡張すると、実行時に実装クラスが自動生成される
	 *	ジェネリクスで永続化対象のクラス「Customer」を指定し、キー項目の型を「Integer」と指定する
	 * @author 真
	 *
	 */
	public interface CustomerRepository extends JpaRepository<Customer, Integer>{
		
	}
