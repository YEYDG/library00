package com.example.library00.book.dao;

import com.example.library00.book.dao.mapper.ReaderCardMapper;
import com.example.library00.book.domain.ReaderCard;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lhd
 * @version 1.0
 * @date 2024/3/5 22:59
 */
@Mapper
@Repository
public class ReaderCardDao implements ReaderCardMapper {
    @Autowired
    SqlSessionTemplate sqlSessionTemplate;
    private final static String NAMESPACE = "com.example.library00.book.dao.mapper.ReaderCardMapper.";

    public ReaderCard findReaderCardByReaderId(long readerId){
       return sqlSessionTemplate.selectOne(NAMESPACE+"findReaderCardByReaderId",readerId);
    }
    public int addReaderCard(ReaderCard readerCard){
        return sqlSessionTemplate.insert(NAMESPACE+"addReaderCard",readerCard);
    }
    public int rePasswd(long readerId,String newPasswd){
        Map<String,Object> paramMap = new HashMap();
        paramMap.put("readerId",readerId);
        paramMap.put("newPasswd",newPasswd);
        return sqlSessionTemplate.update(NAMESPACE+"rePasswd",paramMap);
    }
    public int deleteReaderCard(long readerId){
        return sqlSessionTemplate.delete(NAMESPACE+"deleteReaderCard",readerId);
    }
}
