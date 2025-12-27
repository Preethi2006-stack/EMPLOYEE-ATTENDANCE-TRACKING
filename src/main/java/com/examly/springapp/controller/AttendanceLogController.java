package com.examly.springapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.AttendanceLog;
import com.examly.springapp.service.AttendanceLogService;

@RestController
@RequestMapping("/attendancelogs")
public class AttendanceLogController {

    @Autowired
    private AttendanceLogService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AttendanceLog add(@RequestBody AttendanceLog log) {
        return service.save(log);
    }

    @PutMapping("/{id}")
    public AttendanceLog update(@PathVariable Long id, @RequestBody AttendanceLog log) {
        return service.update(id, log);
    }

    @GetMapping
    public List<AttendanceLog> getAll() {
        return service.getAll();
    }
}
