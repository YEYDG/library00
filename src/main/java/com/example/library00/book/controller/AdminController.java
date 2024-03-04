package com.example.library00.book.controller;

import com.example.library00.book.domain.Admin;
import com.example.library00.book.model.ResponseBase;
import com.example.library00.book.service.AdminService;
import com.example.library00.book.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {
    @Autowired
    IAdminService IAdminService;

    @PostMapping("RegisterAdmin")
    public Object RegisterAdmin(@RequestBody Admin admin){
        boolean flag = IAdminService.RegisterAdmin(admin);
        if(flag) return ResponseBase.success(admin);
        else return ResponseBase.error(123,"用户ID已存在");
    }

    @PostMapping("rePassword")
    public Object rePassword(@RequestBody Admin admin){
        boolean flag = IAdminService.rePassword(admin);
        if(flag) return ResponseBase.success(admin);
        else return ResponseBase.error(101,"此ID不存在");
    }

    @GetMapping("getPassword")
    public Object getPassword(@RequestParam long adminId){
        //boolean flag = adminService.findAdminId(adminId);
        //if(flag) {
            return ResponseBase.success(IAdminService.getPassword(adminId)) ;
        //}
        //else return ResponseBase.error(101,"此ID不存在");
    }
}
