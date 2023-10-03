package com.demo.sessionrecorder.controller;

import com.demo.sessionrecorder.model.Operator;
import com.demo.sessionrecorder.service.OperatorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OperatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OperatorService operatorService;

    @Test
    public void testGetAllOperators() throws Exception {
        Operator operatorOstkreuz = new Operator();
        operatorOstkreuz.setName("OP Ostkreuz");
        Operator operatorSuedkreuz = new Operator();
        operatorSuedkreuz.setName("OP Südkreuz");
        List<Operator> operators = Arrays.asList(operatorOstkreuz, operatorSuedkreuz);
        when(operatorService.getAllOperators()).thenReturn(operators);

        mockMvc.perform(get("/operator/getAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("OP Ostkreuz")))
                .andExpect(jsonPath("$[1].name", is("OP Südkreuz")));
    }
}
