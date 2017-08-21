package com.DevProgress.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DevProgress.domain.Customer;
import com.DevProgress.repository.CustomerRepository;

@Service	//サービスクラスであることを記すアノテーション
@Transactional	//トランザクションを扱うクラスであることを記すアノテーション
public class CustomerService{
	@Autowired	//DIコンテナからインスタンスを取得
	CustomerRepository repository;
	
	//顧客全件取得
	public List<Customer> findAll() {
		return repository.findAll();
	}
	
	//顧客1件取得
	public Customer findOne(Integer id){
		return repository.findOne(id);
	}
	
	//顧客1件作成
	public Customer create(Customer customer){
		return repository.save(customer);
	}
	
	//顧客1件更新
	public Customer update(Customer customer){
		return repository.save(customer);
	}
	
	//顧客1件更新
	public void delete(Integer id){
		repository.delete(id);
	}
		
	
	
	
	
	
	
	
	
	
	
}