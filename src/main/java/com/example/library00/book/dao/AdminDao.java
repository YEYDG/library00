package com.example.library00.book.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

    private static final String MATCH_ADMIN_SQL="SELECT COUNT(*) FROM admin where admin_id = ? AND password = ?";
    private static final String RE_PASSWORD_SQL="UPDATE admin set password = ? where admin_id = ? AND password = ?";
    private static final String GET_PASSWD_SQL="SELECT password from admin where admin_id = ?";
    private static final String FIND_ADMIN_ID="SELECT COUNT(*) FROM admin WHERE admin_id = ?";
    private static final String ADD_ADMIN_SQL="INSERT INTO admin (admin_id, password) VALUES (?, ?);";
    public int getMatchCount(long adminId,String password){
        return jdbcTemplate.queryForObject(MATCH_ADMIN_SQL,new Object[]{adminId,password},Integer.class);
    }
    public int rePassword(long adminId,String newPasswd){
        return jdbcTemplate.update(RE_PASSWORD_SQL,new Object[]{newPasswd,adminId});
    }
    public String getPasswd(long id){
        return jdbcTemplate.queryForObject(GET_PASSWD_SQL,new Object[]{id},String.class);
    }
    public boolean findAdminId(long id){
        return jdbcTemplate.queryForObject(FIND_ADMIN_ID,new Object[]{id},Long.class) > 0;
    }
    public void addAdmin(long adminId,String password){
        jdbcTemplate.update(ADD_ADMIN_SQL,new Object[]{adminId,password});
    }
}
