package com.example.library00.book.dao;

import com.example.library00.book.dao.mapper.ReaderMapper;
import com.example.library00.book.domain.Reader;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lhd
 * @version 1.0
 * @date 2024/3/4 0:17
 */
@Mapper
@Repository
@Slf4j
public class ReaderDao  implements ReaderMapper {
    private final static String NAMESPACE = "com.example.library00.book.dao.mapper.ReaderMapper.";
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;


    public ArrayList<Reader> getAllReader() {
        List<Reader> allReader;
        allReader=sqlSessionTemplate.selectList(NAMESPACE+"getAllReader");
        return (ArrayList<Reader>)allReader;
    }


    public Reader findReaderByReaderId(long readerId) {
        return sqlSessionTemplate.selectOne(NAMESPACE+"findReaderByReaderId");
    }


    public int deleteReader(long readerId) {
        return sqlSessionTemplate.delete(NAMESPACE+"deleteReader",readerId);
    }


    public int editReader(Reader reader) {
        return sqlSessionTemplate.update(NAMESPACE+"editReader",reader);
    }


    public int editReaderCard(Reader reader) {
        return sqlSessionTemplate.update(NAMESPACE+"editReaderCard",reader);
    }


    public long addReader(Reader reader) {
        log.info("\naddReader id:"+reader.getReaderId()+"\nname:"+reader.getName());
        return sqlSessionTemplate.insert(NAMESPACE+"addReader",reader);
    }
}
