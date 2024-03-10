package com.example.library00.book.dao.repo;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.library00.book.DTO.BackBookDTO;
import com.example.library00.book.domain.Lend;

import java.util.ArrayList;

/**
 * @author lhd
 * @version 1.0
 * @date 2024/3/9 22:09
 */
public interface ILendBookRepo {
    int insert(Lend lend);
    int updateBackDateByBookId(BackBookDTO backBoolDTO);
    ArrayList<Lend> queryLendList();
    ArrayList<Lend> myLendListByReaderId(long readerId);
}
