package com.example.library00.book.dao;

import com.example.library00.book.dao.mapper.AdminMapper;
import com.example.library00.book.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Mapper
public class AdminDao implements AdminMapper {
    @Autowired
    SqlSessionTemplate sqlSessionTemplate;
    private final static String NAMESPACE = "com.example.library00.book.dao.mapper.AdminMapper.";
    public int getMatchCount(long adminId,String password){
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("adminId",adminId);
        paramMap.put("password",password);
        return sqlSessionTemplate.selectOne(NAMESPACE+"getMAthCount",paramMap);
    }
    public int rePassword(long adminId,String newPasswd){
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("adminId",adminId);
        paramMap.put("newPasswd",newPasswd);
        return sqlSessionTemplate.update(NAMESPACE+"rePassword",paramMap);}
    public String getPasswd(long id){
        return sqlSessionTemplate.selectOne(NAMESPACE+"getPasswd",id);
    }
    public boolean findAdminId(long id) {
        int count = sqlSessionTemplate.selectOne(NAMESPACE + "findAdminId", id);
        return count > 0;
    }

    public void addAdmin(long adminId,String password){
        Admin admin= new Admin();
        admin.setAdminId(adminId);
        admin.setPassword(password);
        sqlSessionTemplate.update(NAMESPACE+"addAdmin",admin);
    }
}
