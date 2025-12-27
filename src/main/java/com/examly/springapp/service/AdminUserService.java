package com.examly.springapp.service;

import com.examly.springapp.model.AdminUser;
import java.util.List;

public interface AdminUserService {
    AdminUser createAdmin(AdminUser adminUser);
    AdminUser getAdminById(Long id);
    AdminUser updateAdmin(Long id, AdminUser adminUser);
    List<AdminUser> getAllAdmins();
}
