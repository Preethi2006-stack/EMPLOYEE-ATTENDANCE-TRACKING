package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Employee;
import com.examly.springapp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee save(Employee emp) {
        emp.setId(null); // ensure new record
        return repository.save(emp);
    }

    @Override
    public Employee getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Employee update(Long id, Employee emp) {
        return repository.findById(id).map(e -> {
            e.setEmpCode(emp.getEmpCode());
            e.setName(emp.getName());
            e.setEmail(emp.getEmail());
            e.setDepartment(emp.getDepartment());
            return repository.save(e);
        }).orElse(null);
    }

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
    }
    @Override
public void delete(Long id) {
    repository.deleteById(id);
}

}
