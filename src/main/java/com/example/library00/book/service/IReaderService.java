package com.example.library00.book.service;

import com.example.library00.book.domain.Reader;

import java.util.ArrayList;

/**
 * @author lhd
 * @version 1.0
 * @date 2024/3/4 23:55
 */
public interface IReaderService {
    public ArrayList<Reader> getAllReader();
    public boolean deleteReader(long readerId);

    public Reader getReader(long readerId);
    public boolean editReader(Reader reader);
    public boolean editReaderCard(Reader reader);
    public boolean addReader(Reader reader);

}
