package com.example.demo.testcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BankRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAccount(String a, String b, Integer c, String d) {
        String sql = "INSERT INTO bank_account (account_nr, name, balance, id_code) VALUES (:v1, :v2, :v3, :v4)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("v1", b);
        paramMap.put("v2", a);
        paramMap.put("v3", c);
        paramMap.put("v4", d);
        jdbcTemplate.update(sql, paramMap);
    }

    public int getAccountBalance(String a) {
        String sql = "SELECT balance FROM bank_account WHERE account_nr=:v1";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("v1", a);
        Integer balance = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
        return balance;
    }

    public void setBalance(String a, Integer b){
        String sql2 = "UPDATE bank_account SET balance=:v2 WHERE account_nr=:v1";
        Map<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("v1", a);
        paramMap2.put("v2", b);
        jdbcTemplate.update(sql2, paramMap2);
    }

}
