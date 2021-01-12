package com.example.demo.testcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    public void createAccount(String a, String b, Integer c, String d) {
        bankRepository.createAccount(a, b, c, d);
    }

    public int getAccountBalance(String a) {
        return bankRepository.getAccountBalance(a);
    }

    public int depositMoney(String a, Integer b) {
        if (b > 0) {
            Integer new_balance = bankRepository.getAccountBalance(a) + b;
            bankRepository.setBalance(a, new_balance);
            return bankRepository.getAccountBalance(a);

        } else {
            return bankRepository.getAccountBalance(a);
        }
    }

    public int withdrawMoney(String a, Integer b) {
        if (b > 0) {
            Integer new_balance = bankRepository.getAccountBalance(a) - b;
            if (new_balance >= 0) {
                bankRepository.setBalance(a, new_balance);
                return bankRepository.getAccountBalance(a);
            } else {
                return bankRepository.getAccountBalance(a);
            }

        } else {
            return bankRepository.getAccountBalance(a);
        }
    }

    public void transferMoney(String a, String b, Integer c) {
        if (c > 0) {
            Integer new_balance1 = bankRepository.getAccountBalance(a) - c;
            Integer new_balance2 = bankRepository.getAccountBalance(b) + c;

            if (new_balance1 >= 0) {
                bankRepository.setBalance(a, new_balance1);
                bankRepository.setBalance(b, new_balance2);

            }

        }
    }
}
