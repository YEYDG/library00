package com.example.library00.book.service;

import com.example.library00.book.domain.Reader;

import java.util.ArrayList;

/**
 * @author lhd
 * @version 1.0
 * @date 2024/3/4 23:55
 */
public interface IReaderService {
     ArrayList<Reader> getAllReader();
     boolean deleteReader(long readerId);

     Reader getReader(long readerId);
     boolean editReader(Reader reader);
     boolean editReaderCard(Reader reader);
     boolean addReader(Reader reader);

}
