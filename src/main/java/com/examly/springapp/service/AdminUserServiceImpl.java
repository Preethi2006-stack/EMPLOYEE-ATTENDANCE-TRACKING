package com.examly.springapp.service;

import com.examly.springapp.model.AdminUser;
import com.examly.springapp.repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserRepository adminUserRepository;

    @Override
    public AdminUser createAdmin(AdminUser adminUser) {
        return adminUserRepository.save(adminUser);
    }

    @Override
    public AdminUser getAdminById(Long id) {
        return adminUserRepository.findById(id).orElse(null);
    }

    @Override
    public AdminUser updateAdmin(Long id, AdminUser adminUser) {
        adminUser.setId(id);
        return adminUserRepository.save(adminUser);
    }

    @Override
    public List<AdminUser> getAllAdmins() {
        return adminUserRepository.findAll();
    }
}
