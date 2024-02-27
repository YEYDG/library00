package com.example.library00.book.web;

import com.example.library00.book.domain.Book;
import com.example.library00.book.model.ResponseBase;
import com.example.library00.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/addbook",method = RequestMethod.POST)
    public Object addbook(@RequestBody Book book){
        boolean flag = bookService.addBook(book);
        if(flag) return ResponseBase.success(book);

        return ResponseBase.error(911,"书籍添加失败");
    }


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
}
