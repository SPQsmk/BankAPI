package com.bootcamp.controller;

import com.bootcamp.dto.DepositDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {
    private final MockMvc mockMvc;

    @Autowired
    public AccountControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void getBalanceTest() throws Exception {
        mockMvc.perform(get("/accounts/1/balance"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"balance\":200}"));
    }

    @Test
    public void depositMoneyTest() throws Exception {
        mockMvc.perform(put("/accounts/update-balance")
                .content(new ObjectMapper().writeValueAsString(new DepositDTO(1L, BigDecimal.valueOf(100.0))))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
