package com.examly.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.AttendanceLog;
import com.examly.springapp.repository.AttendanceLogRepository;

@Service
public class AttendanceLogServiceImpl implements AttendanceLogService {

    @Autowired
    private AttendanceLogRepository repo;

    public AttendanceLog save(AttendanceLog log) {
        return repo.save(log);
    }

    public AttendanceLog update(Long id, AttendanceLog log) {
        log.setId(id);
        return repo.save(log);
    }

    public List<AttendanceLog> getAll() {
        return repo.findAll();
    }
}
