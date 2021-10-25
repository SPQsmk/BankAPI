package com.bootcamp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ClientControllerTest {
    private final MockMvc mockMvc;

    @Autowired
    public ClientControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void getCardsTest() throws Exception {
        mockMvc.perform(get("/clients/1/cards"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"number\":\"5209088145343565\"},{\"id\":2,\"number\":\"5145671146971166\"}]"));
    }
}
