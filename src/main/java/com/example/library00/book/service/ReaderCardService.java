package com.example.library00.book.service;

import com.example.library00.book.dao.ReaderCardDao;
import com.example.library00.book.dao.ReaderDao;
import com.example.library00.book.domain.Reader;
import com.example.library00.book.domain.ReaderCard;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lhd
 * @version 1.0
 * @date 2024/3/6 10:26
 */
@Slf4j
@Service("ReaderCardService")
public class ReaderCardService implements IReaderCardService{
    @Autowired
    private ReaderCardDao readerCardDao;
    //private ReaderDao readerDao;
    @Autowired
    private IReaderService iReaderService;

    @Autowired
    private ReaderDao readerDao;
    public boolean readerRegister(ReaderCard readerCard){
        log.info("通过1111111111？》》》》》》》》》》》》》》》");
        ReaderCard flag = readerCardDao.findReaderCardByReaderId(readerCard.getReaderId());
        if(flag==null) {
            log.info("\n通过2222222222222？》》》》》》》》》》》》》》》");
            Reader reader = new Reader(readerCard.getReaderId(),readerCard.getName());
            log.info("id:"+reader.getReaderId());
            //iReaderService.addReader(reader);
            readerDao.addReader(reader);
            log.info("\n33333333333？》》》》》》》》》》》》》》》");
            return  readerCardDao.addReaderCard(readerCard) > 0;
        }
        return false;
    }
    public boolean readerLogin(ReaderCard readerCard){
        ReaderCard flag = readerCardDao.findReaderCardByReaderId(readerCard.getReaderId());
        if(flag!=null && flag.getPasswd().equals(readerCard.getPasswd())) return true;
        else return false;
    }
    public boolean readerLogout(ReaderCard readerCard){
        return true;
    }
    public boolean rePasswd(long readerId,String newPasswd){
        log.info("\n >>>>>>>>>>>>>>>>>11111<<<<<<<<<<<<<<<<<"+readerId);

        ReaderCard flag = readerCardDao.findReaderCardByReaderId(readerId);
        log.info("\n"+flag.getReaderId());
        if(flag != null){
            log.info("\n adfadssdfada"+newPasswd);
            return readerCardDao.rePasswd(readerId,newPasswd)>0;
        }
        return false;
    }
    public boolean deleteReaderCard(long readerId){
        boolean flag1 = iReaderService.deleteReader(readerId);
        boolean flag2 = readerCardDao.deleteReaderCard(readerId) > 0;
        return flag2&&flag1;
    }

}
