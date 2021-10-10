package com.springcloud.example.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.yml")
@SpringBootTest
class RuntimeControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void getPropertyValue() throws Exception {
        mvc.perform(get("/version"))
                .andExpect(status().isOk())
                .andExpect(content().string("0.0.1-SNAPSHOT"));
    }

    @Test
    void getPropertyName() throws Exception {
        mvc.perform(get("/name"))
                .andExpect(status().isOk())
                .andExpect(content().string("spring-cloud"));
    }
}