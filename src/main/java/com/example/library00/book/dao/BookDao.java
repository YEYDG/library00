package com.example.library00.book.dao;

import com.example.library00.book.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lhd
 * @version 1.0
 * @date 2024/2/29 23:19
 */

@Repository
@Mapper
public class BookDao implements BookMapper{
    private final static  String NAMESPACE = "com.example.library00.book.dao.BookMapper.";
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public int matchBook(final String searchWord){
        String search = "%" + searchWord + "%";
        return sqlSessionTemplate.selectOne(NAMESPACE+"matchBook",search);
    }

    public ArrayList<Book> queryBook(final String searchWord){
        String search = "%" + searchWord + "%";
        List<Book> result = sqlSessionTemplate.selectList(NAMESPACE+"queryBook",search);
        return (ArrayList<Book>) result;
    }

    public ArrayList<Book> getAllBooks(){
        List<Book> result = sqlSessionTemplate.selectList(NAMESPACE+"getAllBooks");
        return (ArrayList<Book>) result;
    }

    public int addBook(final Book book){
        return sqlSessionTemplate.insert(NAMESPACE+"addBook",book);
    }
    public Book getBook(final long bookId){
        return sqlSessionTemplate.selectOne(NAMESPACE+"getBook",bookId);
    }
    public int editBook(final Book book){
        return sqlSessionTemplate.update(NAMESPACE+"editBook",book);
    }
    public int deleteBook(final long bookId){
        return sqlSessionTemplate.delete(NAMESPACE+"deleteBook",bookId);
    }

}
