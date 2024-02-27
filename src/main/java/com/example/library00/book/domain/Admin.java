package com.example.library00.book.domain;

public class Admin {
    private int adminId;
    private String password;

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public void setPassword(String password){this.password = password;}

    public int getAdminId() {
        return adminId;
    }


    public String getPassword() {
        return password;
    }
}
