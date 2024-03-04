package com.example.library00.book.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lhd
 * @version 1.0
 * @date 2024/3/4 0:05
 */
public class Reader implements Serializable {

    private long readerId;
    private String name;
    private String sex;
    private Date birth;
    private String address;
    private String telcode;

    public long getReaderId() {
        return readerId;
    }

    public void setReaderId(long readerId) {
        this.readerId = readerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return telcode;
    }

    public void setPhone(String phone) {
        this.telcode = phone;
    }
}
