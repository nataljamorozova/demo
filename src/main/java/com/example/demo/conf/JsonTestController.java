package com.example.demo.conf;

import com.example.demo.testcontroller.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class JsonTestController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private KasutajaRepository kasutajaRepository;

    @CrossOrigin
    @PostMapping("register")
    public void register(@RequestBody LoginRequest request){
        String encodedPassword=passwordEncoder.encode(request.password);
        kasutajaRepository.registreeri(request.username, encodedPassword);
    }
}
