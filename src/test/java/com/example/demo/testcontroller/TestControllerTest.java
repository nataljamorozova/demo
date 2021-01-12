package com.example.demo.testcontroller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

public class TestControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testAbsMethod() throws Exception {
        RequestBuilder request= MockMvcRequestBuilders.get("/math/abs/-2").contentType("application/json");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Abs väärtus on: 2"));
    }

}
