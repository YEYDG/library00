package com.example.library00.book.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author lhd
 * @version 1.0
 * @date 2024/3/1 21:10
 */
@Mapper
public interface AdminMapper {
    int getMatchCount(long adminId,String password);
    int rePassword(long adminId,String newPasswd);
    String getPasswd(long id);
    boolean findAdminId(long id);
    void addAdmin(long adminId,String password);
}
