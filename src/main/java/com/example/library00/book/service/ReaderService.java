package com.example.library00.book.service;

import com.example.library00.book.dao.ReaderDao;
import com.example.library00.book.domain.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author lhd
 * @version 1.0
 * @date 2024/3/4 0:28
 */
@Service("ReaderService")
public class ReaderService implements IReaderService{
    @Autowired
    ReaderDao readerDao;
    public ArrayList<Reader> getAllReader(){
        ArrayList<Reader> allReader;
        allReader = readerDao.getAllReader();
        return allReader;
    }
    public boolean deleteReader(long readerId){
        return readerDao.deleteReader(readerId) > 0;
    }

    public Reader getReader(long readerId){
        Reader reader = readerDao.findReaderByReaderId(readerId);
        return reader;
    }
    public boolean editReader(Reader reader){
        return readerDao.editReader(reader) > 0;
    }
    public boolean editReaderCard(Reader reader){
        return readerDao.editReaderCard(reader) > 0;
    }
    public boolean addReader(Reader reader){
        return readerDao.addReader(reader) > 0;
    }

}
