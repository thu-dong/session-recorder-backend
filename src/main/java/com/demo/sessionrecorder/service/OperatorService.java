package com.demo.sessionrecorder.service;

import com.demo.sessionrecorder.model.Operator;

import java.util.List;

public interface OperatorService {
    public Operator saveSession(Operator operator);
    public List<Operator> getAllOperators();
}
