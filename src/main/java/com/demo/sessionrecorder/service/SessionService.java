package com.demo.sessionrecorder.service;

import com.demo.sessionrecorder.model.Session;

import java.util.List;

public interface SessionService {
    public Session saveSession(Session session);
    public List<Session> getAllSessions();
}
