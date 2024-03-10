package com.example.library00.book.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.library00.book.DTO.BackBookDTO;
import com.example.library00.book.DTO.LendBookDTO;
import com.example.library00.book.domain.Lend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lhd
 * @version 1.0
 * @date 2024/3/9 14:20
 */
public interface ILendService {
    boolean lendBook(LendBookDTO lendBookDTO);
    boolean backBook(BackBookDTO backBookDTO);
    ArrayList<Lend> lendList();

    ArrayList<Lend> myLendList(long readerId);

}
