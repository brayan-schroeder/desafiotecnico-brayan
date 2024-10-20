package com.desafiotecnico.brayan.filme;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FilmeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnIntervaloPremios() throws Exception {
        mockMvc.perform(get("/filmes/intervalo_premios"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.min[0].producer").exists())
                .andExpect(jsonPath("$.max[0].producer").exists())
                .andExpect(jsonPath("$.min[0].interval").exists())
                .andExpect(jsonPath("$.max[0].interval").exists());
    }
}
