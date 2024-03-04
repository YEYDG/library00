package com.example.library00.book.service;

import com.example.library00.book.dao.BookDao;
import com.example.library00.book.domain.Book;

import java.util.ArrayList;

/**
 * @author lhd
 * @version 1.0
 * @date 2024/3/4 22:39
 */
public interface IBookService {
    public void setBookDao(BookDao bookDao) ;
    public ArrayList<Book> queryBook(String bookName);

    public ArrayList<Book> getAllBooks();

    public int deleteBook(long bookId);

    public int matchBook(String searchWord);

    public boolean addBook(Book book);

    public Book getBook(long bookId);

    public boolean editBook(Book book);
}
