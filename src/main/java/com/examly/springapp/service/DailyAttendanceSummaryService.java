// package com.examly.springapp.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.*;
// import org.springframework.stereotype.Service;

// import com.examly.springapp.model.DailyAttendanceSummary;
// import com.examly.springapp.repository.DailyAttendanceSummaryRepository;

// @Service
// public class DailyAttendanceSummaryService {

//     @Autowired
//     private DailyAttendanceSummaryRepository repository;

//     public Page<DailyAttendanceSummary> getByEmployeeCode(
//             String empCode, Pageable pageable) {
//         return repository.findByEmployeeCode(empCode, pageable);
//     }
// }
package com.examly.springapp.service;

import com.examly.springapp.model.DailyAttendanceSummary;
import com.examly.springapp.repository.DailyAttendanceSummaryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DailyAttendanceSummaryService {

    private final DailyAttendanceSummaryRepository repo;

    public DailyAttendanceSummaryService(DailyAttendanceSummaryRepository repo) {
        this.repo = repo;
    }

    // Create a new daily attendance summary
    public DailyAttendanceSummary create(DailyAttendanceSummary summary) {
        return repo.save(summary);
    }

    // Get summaries by employee code and date range
    public List<DailyAttendanceSummary> getByEmployeeAndDateRange(String employeeCode, LocalDate startDate, LocalDate endDate) {
        List<DailyAttendanceSummary> summaries = repo.findByEmployeeCodeAndDateBetween(employeeCode, startDate, endDate);
        return summaries != null ? summaries : List.of(); // ensures no null is returned
    }
}

