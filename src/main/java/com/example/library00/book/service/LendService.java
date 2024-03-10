package com.example.library00.book.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.library00.book.DTO.BackBookDTO;
import com.example.library00.book.DTO.LendBookDTO;
import com.example.library00.book.dao.mapper.LendMapper;
import com.example.library00.book.dao.repo.ILendBookRepo;
import com.example.library00.book.domain.Lend;
import jakarta.annotation.Priority;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lhd
 * @version 1.0
 * @date 2024/3/9 14:21
 */
@Service
@Primary
public class LendService implements ILendService{
    @Resource
    private ILendBookRepo iLendBookRepo;

    @Autowired
    private LendMapper lendMapper;

    public boolean lendBook(LendBookDTO lendBookDTO){
        Date nowDate = new Date();
        Lend lend = Lend.builder().
                bookId(lendBookDTO.getBookId()).
                readerId(lendBookDTO.getReaderId()).
                lendDate(nowDate).
                backDate(null).build();
        return iLendBookRepo.insert(lend) > 0;
    }

    public boolean backBook(BackBookDTO backBookDTO){
        return iLendBookRepo.updateBackDateByBookId(backBookDTO)>0;
    }
    public ArrayList<Lend> lendList(){
        return iLendBookRepo.queryLendList();
    }

    public ArrayList<Lend> myLendList(long readerId){

        return (ArrayList<Lend>) iLendBookRepo.myLendListByReaderId(readerId);
    }
}
