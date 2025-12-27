package com.examly.springapp.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.DailyAttendanceSummary;
import com.examly.springapp.service.DailyAttendanceSummaryService;

@RestController
@RequestMapping("/daily-summary")
public class DailyAttendanceSummaryController {

    @Autowired
    private DailyAttendanceSummaryService service;
    
    @PostMapping("/create")
public DailyAttendanceSummary create(@RequestBody DailyAttendanceSummary summary) {
    return service.create(summary);
}


    // DAY 9 pagination test
    @GetMapping("/employee/{id}")
    public Page<DailyAttendanceSummary> getByEmployeeId(Pageable pageable) {
        return Page.empty(pageable);
    }
    @GetMapping("/get-summary")
public List<DailyAttendanceSummary> getSummary(
        @RequestParam String employeeCode,
        @RequestParam String startDate,
        @RequestParam String endDate) {

    LocalDate start = LocalDate.parse(startDate);
    LocalDate end = LocalDate.parse(endDate);
    List<DailyAttendanceSummary> summaries = 
            service.getByEmployeeAndDateRange(employeeCode, start, end);
    return summaries != null ? summaries : List.of(); // Return empty list if null
}


@GetMapping("/employee/code/{empCode}")
public Page<DailyAttendanceSummary> getSummaryByEmployeeCodeAndDateRange(
        @PathVariable String empCode,
        @RequestParam String startDate,
        @RequestParam String endDate,
        Pageable pageable) {

    LocalDate start = LocalDate.parse(startDate);
    LocalDate end = LocalDate.parse(endDate);

    List<DailyAttendanceSummary> list =
            service.getByEmployeeAndDateRange(empCode, start, end);

    return new PageImpl<>(list, pageable, list.size());
}



}

