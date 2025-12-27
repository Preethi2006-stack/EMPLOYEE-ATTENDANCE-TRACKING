package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.AttendanceLog;

public interface AttendanceLogService {
    AttendanceLog save(AttendanceLog log);
    AttendanceLog update(Long id, AttendanceLog log);
    List<AttendanceLog> getAll();
}
