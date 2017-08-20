package com.DevProgress.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  // DIする対象の目印
public class SampleService {
    @Autowired  // d -> DIコンテナからインスタンスを取得する
   // private Customer customer;

    public String getMessage() {
        System.out.println("★★★★★ Service called.");
        return null;
       // return "Hello world. Hello "+customerRepository.getCustomer()+".";
    }
}