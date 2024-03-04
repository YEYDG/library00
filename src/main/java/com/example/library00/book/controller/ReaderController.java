package com.example.library00.book.controller;

import com.example.library00.book.domain.Reader;
import com.example.library00.book.service.IReaderService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lhd
 * @version 1.0
 * @date 2024/3/4 23:57
 */
@RestController
public class ReaderController {
    @Autowired
    private IReaderService iReaderService;

    @GetMapping("getAllReader")
    ResponseEntity<List<Reader>> getAllReader(){
        ArrayList<Reader> allReader = iReaderService.getAllReader();
        return ResponseEntity.ok((List)allReader) ;
    }
}
