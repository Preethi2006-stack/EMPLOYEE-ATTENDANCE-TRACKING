// package com.examly.springapp.service;

// import java.util.List;

// import com.examly.springapp.model.Employee;

// public interface EmployeeService {
//     Employee save(Employee emp);
//     Employee update(Long id, Employee emp);
//     Employee getById(Long id);
//     List<Employee> getAll();
// }
package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Employee;

public interface EmployeeService {
    Employee save(Employee emp);
    Employee update(Long id, Employee emp);
    Employee getById(Long id);
    List<Employee> getAll();
    
    // Delete employee by ID
    void delete(Long id);
}
