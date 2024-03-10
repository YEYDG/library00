package com.example.library00.book.controller;

import com.example.library00.book.DTO.BackBookDTO;
import com.example.library00.book.DTO.LendBookDTO;
import com.example.library00.book.domain.Lend;
import com.example.library00.book.service.ILendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


/**
 * @author lhd
 * @version 1.0
 * @date 2024/3/9 21:42
 */
@RestController
public class LendController {
    @Autowired
    ILendService iLendService;

    @PostMapping("lendBook")
    public ResponseEntity<Object> lendBook(@RequestBody LendBookDTO lendBookDTO){
        boolean flag = iLendService.lendBook(lendBookDTO);
        return ResponseEntity.ok(flag);
    }

    @PostMapping("backBook")
    ResponseEntity<Object> backBook(@RequestParam BackBookDTO backBookDTO){
        boolean flag = iLendService.backBook(backBookDTO);
        return ResponseEntity.ok(flag);
    }

    @RequestMapping("getLendList")
    ResponseEntity<ArrayList<Lend>> getLendList(){
        ArrayList<Lend> lendList = iLendService.lendList();
        return ResponseEntity.ok(lendList);
    }
    @GetMapping("getMyLendList")
    ResponseEntity<ArrayList<Lend>> getMyLendList(@RequestParam long readerId){
        ArrayList<Lend> myList = iLendService.myLendList(readerId);
        return ResponseEntity.ok(myList);
    }

}
