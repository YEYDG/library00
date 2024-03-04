package com.example.library00.book.service;

import com.example.library00.book.domain.Admin;

/**
 * @author lhd
 * @version 1.0
 * @date 2024/3/4 22:47
 */
public interface IAdminService {
    public boolean findAdminId(long adminId);

    public boolean RegisterAdmin(Admin admin);

    public boolean rePassword(Admin admin);

    public String getPassword(long adminId);
}
