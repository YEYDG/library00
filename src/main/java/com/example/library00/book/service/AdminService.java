package com.example.library00.book.service;

import com.example.library00.book.dao.AdminDao;
import com.example.library00.book.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminDao adminDao;

    public boolean findAdminId(long adminId) {
        return adminDao.findAdminId(adminId);
    }

    public boolean Register(Admin admin){
        boolean flag = adminDao.findAdminId(admin.getAdminId());
        if(!flag){
         adminDao.addAdmin(admin.getAdminId(),admin.getPassword());
         return true;
        }
        else {
            System.out.println("已经存在了！！");
            return false;
        }
    }

    public boolean rePassword(Admin admin){
        boolean flag = adminDao.findAdminId(admin.getAdminId());
        if(flag) {
            adminDao.rePassword(admin.getAdminId(), admin.getPassword());
            return true;
        }
        else {
            System.out.println("此ID不存在");
            return false;
        }
    }

    public String getPassword(long adminId){
       return adminDao.getPasswd(adminId);
    }

}
