// package com.examly.springapp.repository;

// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import com.examly.springapp.model.DailyAttendanceSummary;

// @Repository
// public interface DailyAttendanceSummaryRepository
//         extends JpaRepository<DailyAttendanceSummary, Long> {

//     Page<DailyAttendanceSummary> findByEmployeeCode(String employeeCode, Pageable pageable);
// }
package com.examly.springapp.repository;

import com.examly.springapp.model.DailyAttendanceSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface DailyAttendanceSummaryRepository extends JpaRepository<DailyAttendanceSummary, Long> {

    // Returns a list of summaries for the employee between start and end dates
    List<DailyAttendanceSummary> findByEmployeeCodeAndDateBetween(String employeeCode, LocalDate startDate, LocalDate endDate);

}

