package com.example.demo.testcontroller;


import com.example.demo.SampleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("bank")
@RestController
public class BankController {
   @Autowired
   private BankService bankService;

    @CrossOrigin
    @GetMapping("createaccount")

    public void createAccount(@RequestParam("name") String a,
                              @RequestParam("account_nr") String b,
                              @RequestParam("balance") Integer c, @RequestParam("id_code") String d) {
        bankService.createAccount(a,b,c,d);
    }

    @CrossOrigin
    @GetMapping("getAccountBalance")
    public int getAccountBalance(@RequestParam("iban") String a) {
        return bankService.getAccountBalance(a);
    }

    @GetMapping("depositMoney")
    public int depositMoney(@RequestParam("iban") String a, @RequestParam("deposit") Integer b) {
        return bankService.depositMoney(a,b);
    }


    @GetMapping("withdrawMoney")
    public int withdrawMoney(@RequestParam("iban") String a, @RequestParam("money") Integer b) {
        return bankService.withdrawMoney(a,b);

    }

    @GetMapping("transferMoney")
    public void transferMoney(@RequestParam("iban1") String a, @RequestParam("iban2") String b, @RequestParam("money") Integer c) {
            bankService.transferMoney(a,b,c);
    }
}
