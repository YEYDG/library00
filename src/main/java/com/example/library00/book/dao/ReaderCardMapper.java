package com.example.library00.book.dao;

import com.example.library00.book.domain.ReaderCard;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lhd
 * @version 1.0
 * @date 2024/3/5 22:56
 */
@Mapper
public interface ReaderCardMapper {
    ReaderCard findReaderCardByReaderId(long readerId);
    int addReaderCard(ReaderCard readerCard);
    int rePasswd(long readerId,String newPasswd);
    int deleteReaderCard(long readerId);
}
