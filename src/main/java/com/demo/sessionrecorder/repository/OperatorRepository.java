package com.demo.sessionrecorder.repository;

import com.demo.sessionrecorder.model.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepository extends JpaRepository<Operator, Integer> {
    Boolean existsByName(String name);
}
