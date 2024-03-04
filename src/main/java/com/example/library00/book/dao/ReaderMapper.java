package com.example.library00.book.dao;

import com.example.library00.book.domain.Reader;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

/**
 * @author lhd
 * @version 1.0
 * @date 2024/3/4 0:11
 */
@Mapper
public interface ReaderMapper {
    public ArrayList<Reader> getAllReader();

    public Reader findReaderByReaderId(final long readerId);
    public int deleteReader(final long readerId);
    public int editReader(final Reader reader);
    public int editReaderCard(final Reader reader);
    public long addReader(final Reader reader);
}
