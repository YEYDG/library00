package com.example.library00.book.controller;

import com.example.library00.book.domain.Book;
import com.example.library00.book.model.ResponseBase;
import com.example.library00.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("add")
    public Object add(@RequestBody Book book){
        boolean flag = bookService.addBook(book);
        if(flag)
            return ResponseBase.success();
        return ResponseBase.error(911,"书籍添加失败");
    }

//    @RequestMapping("delete")
//    public Object deletel(@RequestParam long bookId){
//        Boolean flag = bookService.deleteBook(bookId);
//        if(flag) return ResponseBase.success();
//        else return ResponseBase.error(900,"没有此ID");
//    }
    @RequestMapping("delete")
    public Object deletel(@RequestParam long bookId){
        bookService.deleteBook(bookId);
        return ResponseBase.success();

    }

    @GetMapping("findBookId")                          //查找某书
    public Object findBookId(@RequestParam long bookId){            //ID和书名均可查询
        Book book = bookService.getBook(bookId);
        if(book.getBookId() == bookId) return ResponseBase.success(book);
        else return ResponseBase.error(911,"查无此书");
    }
    @GetMapping("findBookName")
    public Object findBookName(@RequestParam String bookName){
        ArrayList<Book> bookList = bookService.queryBook(bookName);
        if(bookList.size()!=0) return ResponseBase.success(bookList);
        else return ResponseBase.error(911,"查无此书");
    }
    @GetMapping("matchBook")                       //查找某书的数量
    public Object matchBook(@RequestParam String searchWord){
        int bookCount = bookService.matchBook(searchWord);
        return ResponseBase.success(bookCount);
    }
    @RequestMapping(value = "/addbook",method = RequestMethod.POST)
    public Object addbook(@RequestBody Book book){
        boolean flag = bookService.addBook(book);
        if(flag) return ResponseBase.success(book);

        return ResponseBase.error(911,"书籍添加失败");
    }
    @GetMapping("allBooks")
    public Object allBooks(){
        ArrayList<Book> books = bookService.getAllBooks();
        if(books.size()!=0) return ResponseBase.success(books);
        else return ResponseBase.error(000,"藏书为空");
    }
////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "//hello",method = RequestMethod.GET)
    public String hello(@RequestParam("id")  String id , @RequestParam("name") String name){
        return "HELLEO springboot"+id+name;
    }
    @GetMapping(value = "/book")
    public ResponseEntity<Book> book(@RequestParam long bookId, @RequestParam String name){
        Book book = new Book();
        book.setName(name);
        book.setBookId(bookId);
        return ResponseEntity.ok(book);
    }

    @RequestMapping(value = "/ceshi")
    public Object ceshi(){
        return ResponseBase.success();
    }
    /////////////////////////////////////////////////////////
}
