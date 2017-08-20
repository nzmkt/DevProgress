package com.DevProgress;


import com.DevProgress.domain.Customer;
import com.DevProgress.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class App implements CommandLineRunner {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... strings) throws Exception {
        Customer customer01 = new Customer();  // ドメインクラスCustomerのインスタンスを作成
        customer01.setName("user01");          // Customerの初期化。フィールドnameに「user01」を設定する
        customer01.setEmail("user01@foo.bar"); // Customerの初期化。フィールドemailに「user01@foo.bar」を設定する
        customerRepository.save(customer01);   // リポジトリクラスの行挿入メソッドを呼び出す
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}