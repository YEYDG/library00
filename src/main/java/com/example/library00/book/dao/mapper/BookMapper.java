package com.example.library00.book.dao.mapper;

import com.example.library00.book.domain.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lhd
 * @version 1.0
 * @date 2024/3/1 0:06
 */
@Mapper
public interface BookMapper {

    int matchBook(String searchWord);
    List<Book> queryBook(String searchWord);
    List<Book> getAllBooks();
    int addBook(Book book);
    Book getBook(long bookId);
    int editBook(Book book);
    int deleteBook(long bookId);


}
