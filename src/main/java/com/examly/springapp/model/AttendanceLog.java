package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
public class AttendanceLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeCode;
    private String date;
    private String checkInTime;
    private String checkOutTime;

    // getters & setters
    public Long getId() { return id; }
    public String getEmployeeCode() { return employeeCode; }
    public String getDate() { return date; }
    public String getCheckInTime() { return checkInTime; }
    public String getCheckOutTime() { return checkOutTime; }

    public void setId(Long id) { this.id = id; }
    public void setEmployeeCode(String employeeCode) { this.employeeCode = employeeCode; }
    public void setDate(String date) { this.date = date; }
    public void setCheckInTime(String checkInTime) { this.checkInTime = checkInTime; }
    public void setCheckOutTime(String checkOutTime) { this.checkOutTime = checkOutTime; }
}
