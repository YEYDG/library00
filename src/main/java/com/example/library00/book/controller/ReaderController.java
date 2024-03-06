package com.example.library00.book.controller;

import com.example.library00.book.domain.Reader;
import com.example.library00.book.domain.ReaderCard;
import com.example.library00.book.service.IReaderCardService;
import com.example.library00.book.service.IReaderService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lhd
 * @version 1.0
 * @date 2024/3/4 23:57
 */
@Slf4j
@RestController
@RequestMapping("/reader/")
public class ReaderController {
    @Resource
    private IReaderService iReaderService;
//    @Autowired
//    @Qualifier("ReaderCardService")
    //@Resource
    @Autowired
    private IReaderCardService iReaderCardService;
    @GetMapping("getAllReader")
    public ResponseEntity<List<Reader>> getAllReader(){
        ArrayList<Reader> allReader = iReaderService.getAllReader();
        return ResponseEntity.ok((List)allReader) ;
    }

    @PostMapping("editReader")
    public ResponseEntity<Reader> editReader(@RequestBody Reader reader){
        boolean flag = iReaderService.editReader(reader);
        return ResponseEntity.ok(reader);
    }

    @PostMapping("readerRegister")
    public ResponseEntity<Object> readerRegister(@RequestBody ReaderCard readerCard){
        boolean flag = iReaderCardService.readerRegister(readerCard);
        return ResponseEntity.ok(flag);
    }

    @PostMapping ("rederLogin")
    public ResponseEntity<Object> rederLogin(@RequestBody ReaderCard readerCard){
        boolean flag = iReaderCardService.readerLogin(readerCard);

        return ResponseEntity.ok(flag);
    }
    @GetMapping("readerLogout")
    public ResponseEntity<Object> readerLogout(@RequestBody ReaderCard readerCard){
        boolean flag = iReaderCardService.readerLogout(readerCard);
        return ResponseEntity.ok(flag);
    }

//    @PostMapping("rePasswd")
//    public ResponseEntity<Object> rePasswd(long readerId,String newPasswd){
//        boolean flag = iReaderCardService.rePasswd(readerId,newPasswd);
//        return ResponseEntity.ok(flag);
//    }

    @PostMapping("rePasswd")
    public ResponseEntity<Object> rePasswd(@RequestBody ReaderCard readerCard) {
        log.info("\n传进来的第一下"+readerCard.getReaderId()+"\n密码是:"+readerCard.getPasswd());
        boolean flag = iReaderCardService.rePasswd(readerCard.getReaderId(), readerCard.getPasswd());
        return ResponseEntity.ok(flag);
    }
    @GetMapping("deleteReader")
    public ResponseEntity<Object> deleteReader(@RequestParam long readerId){
        boolean flag = iReaderCardService.deleteReaderCard(readerId);
        return ResponseEntity.ok(flag);
    }

}
