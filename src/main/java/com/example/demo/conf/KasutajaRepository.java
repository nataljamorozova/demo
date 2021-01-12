package com.example.demo.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class KasutajaRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public String getParool(String a) {
        String sql = "SELECT parool FROM kasutajad WHERE kasutaja=:v1";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("v1", a);
        String parool = jdbcTemplate.queryForObject(sql, paramMap, String.class);
        return parool;
    }

    public void registreeri(String a, String b) {
        String sql = "INSERT INTO kasutajad (kasutaja, parool) VALUES (:v1, :v2)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("v1", a);
        paramMap.put("v2", b);
        jdbcTemplate.update(sql, paramMap);
    }

}
