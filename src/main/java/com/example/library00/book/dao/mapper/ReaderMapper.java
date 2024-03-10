package com.example.library00.book.dao.mapper;

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
     ArrayList<Reader> getAllReader();

     Reader findReaderByReaderId(final long readerId);
     int deleteReader(final long readerId);
     int editReader(final Reader reader);
     int editReaderCard(final Reader reader);
     long addReader(final Reader reader);
}
