package com.demo.sessionrecorder.service;

import com.demo.sessionrecorder.model.Operator;
import com.demo.sessionrecorder.repository.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    OperatorRepository operatorRepository;

    @Override
    public Operator saveSession(Operator operator) {
        return operatorRepository.save(operator);
    }

    @Override
    public List<Operator> getAllOperators() {
        return operatorRepository.findAll();
    }
}
