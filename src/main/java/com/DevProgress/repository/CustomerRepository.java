package com.DevProgress.repository;

import com.DevProgress.domain.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public Customer save(Customer customer) {    // 行挿入メソッド
        SqlParameterSource param                 // SqlParameterSourceクラスは後のSQLの「:」で始まるプレースホルダのパラメータを保持するクラス
            = new BeanPropertySqlParameterSource(customer);  // プレースホルダのマッピングにCustomerクラスのインスタンスを使用する

        jdbcTemplate.update("insert into customer(name, email) " +
            " values(:name, :email)", param);  // NamedParameterJdbcTemplateを使ってSQLを実行する

        return customer;
    }
}