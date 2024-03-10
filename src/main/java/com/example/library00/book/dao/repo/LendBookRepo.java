package com.example.library00.book.dao.repo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.library00.book.DTO.BackBookDTO;
import com.example.library00.book.dao.mapper.LendMapper;
import com.example.library00.book.domain.Lend;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author lhd
 * @version 1.0
 * @date 2024/3/9 22:22
 */
@Repository
@Primary
public class LendBookRepo extends ServiceImpl<LendMapper,Lend> implements ILendBookRepo{
    @Override
    public int insert(Lend lend){
        return baseMapper.insert(lend);
    }
    @Override
    public int updateBackDateByBookId(BackBookDTO backBookDTO){
        Date nowDate = new Date();
        Lend lend = Lend.builder().bookId(backBookDTO.getBookId()).build();
        UpdateWrapper<Lend> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("book_id",backBookDTO.getBookId());
        return baseMapper.update(lend,updateWrapper);
    }
    @Override
    public ArrayList<Lend>  queryLendList(){
        QueryWrapper<Lend> queryWrapper = new QueryWrapper<>();
        return (ArrayList<Lend>) baseMapper.selectList(queryWrapper);
    }
    @Override
    public ArrayList<Lend> myLendListByReaderId(long readerId){
        QueryWrapper<Lend> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("reader_id",readerId);
        return (ArrayList<Lend>) baseMapper.selectList(queryWrapper);
    }
}
