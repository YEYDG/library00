package com.example.library00.book.controller;

import com.example.library00.book.domain.Admin;
import com.example.library00.book.model.ResponseBase;
import com.example.library00.book.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("Register")
    public Object Register(@RequestBody Admin admin){
        boolean flag = adminService.Register(admin);
        if(flag) return ResponseBase.success(admin);
        else return ResponseBase.error(123,"用户ID已存在");
    }

    @PostMapping("rePassword")
    public Object rePassword(@RequestBody Admin admin){
        boolean flag = adminService.rePassword(admin);
        if(flag) return ResponseBase.success(admin);
        else return ResponseBase.error(101,"此ID不存在");
    }
}
