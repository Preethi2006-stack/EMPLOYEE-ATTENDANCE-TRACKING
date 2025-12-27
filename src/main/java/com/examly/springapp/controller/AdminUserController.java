package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.AdminUser;
import com.examly.springapp.service.AdminUserService;

@RestController
@RequestMapping("/admin")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    // testAddAdmin
    @PostMapping("/create")
    public ResponseEntity<AdminUser> addAdmin(@RequestBody AdminUser adminUser) {
        AdminUser saved = adminUserService.createAdmin(adminUser);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    // testGetAdminById
    @GetMapping("/{id}")
    public ResponseEntity<AdminUser> getAdminById(@PathVariable Long id) {
        AdminUser admin = adminUserService.getAdminById(id);
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    // testUpdateAdmin
    @PutMapping("/{id}")
    public ResponseEntity<AdminUser> updateAdmin(
            @PathVariable Long id,
            @RequestBody AdminUser adminUser) {

        AdminUser updated = adminUserService.updateAdmin(id, adminUser);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    // testGetAllAdmins
    @GetMapping
    public ResponseEntity<List<AdminUser>> getAllAdmins() {
        return new ResponseEntity<>(adminUserService.getAllAdmins(), HttpStatus.OK);
    }
}
