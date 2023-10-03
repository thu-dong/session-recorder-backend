package com.demo.sessionrecorder.controller;

import com.demo.sessionrecorder.model.Session;
import com.demo.sessionrecorder.repository.SessionRepository;
import com.demo.sessionrecorder.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/session")
@CrossOrigin
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @Autowired
    private SessionRepository sessionRepository;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Session session){
        try {
            sessionService.saveSession(session);
            return ResponseEntity.ok("Session added successfully");
        } catch (Exception e) {
            return ResponseEntity.ofNullable("");
        }
    }

    @GetMapping("/latestEndTime/{vehicleId}")
    public LocalDateTime getLatestEndTime(@PathVariable Long vehicleId) {
        Sort sort = Sort.by(Sort.Direction.DESC, "endTime");
        List<Session> sessionList = sessionRepository.findByVehicleId(vehicleId, sort);
        if (!sessionList.isEmpty()) {
            return sessionList.get(0).getEndTime();
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No records found for the given Vehicle Id"
            );
        }
    }

    @GetMapping("/getAll")
    public List<Session> getAllSessions(){
        return sessionService.getAllSessions();
    }
}