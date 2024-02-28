package com.example.library00.book.domain;

public class Admin {
    private long adminId;
    private String password;

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    public void setPassword(String password){this.password = password;}

    public long getAdminId() {
        return adminId;
    }


    public String getPassword() {
        return password;
    }
}
