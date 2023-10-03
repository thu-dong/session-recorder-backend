package com.demo.sessionrecorder.repository;

import com.demo.sessionrecorder.model.Session;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {

    List<Session> findByVehicleId(Long vehicleId, Sort sort);
}
