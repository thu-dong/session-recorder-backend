package com.demo.sessionrecorder.controller;

import com.demo.sessionrecorder.model.Operator;
import com.demo.sessionrecorder.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/operator")
@CrossOrigin
public class OperatorController {

    @Autowired
    private OperatorService operatorService;
    @GetMapping("/getAll")
    public List<Operator> getAllOperators(){
        return operatorService.getAllOperators();
    }
}
