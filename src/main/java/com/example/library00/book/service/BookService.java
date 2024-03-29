package com.example.library00.book.service;

import com.example.library00.book.dao.BookDao;
import com.example.library00.book.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;

@Service("BookService")
public class BookService implements IBookService, Serializable {
    private BookDao bookDao;

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
    public ArrayList<Book> queryBook(String bookName){return bookDao.queryBook(bookName);}

    public ArrayList<Book> getAllBooks(){return bookDao.getAllBooks();}

    public int deleteBook(long bookId){
       return bookDao.deleteBook(bookId);

}

    public int matchBook(String searchWord){return bookDao.matchBook(searchWord) ;}

    public boolean addBook(Book book){return bookDao.addBook(book) > 0;}

    public Book getBook(long bookId){return bookDao.getBook(bookId);}

    public boolean editBook(Book book){return bookDao.editBook(book)>0;}

    //    public boolean deleteBook(long bookId){
//        boolean flag = matchBook(bookId);
//        if(flag){
//            bookDao.deleteBook(bookId);
//            return true;
//        }
//        return false;
//    }
//    public boolean findBook(long bookId){
//        ArrayList<Book> allBooks = getAllBooks();
//        for (Book book : allBooks) {
//            if (book != null && book.getBookId() == bookId) {
//                return true; // 如果找到匹配的书籍，则返回 true
//            }
//        }
//        return false; // 如果没有找到匹配的书籍，则返回 false
//    }
}
