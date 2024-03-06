package com.example.library00.book.service;

import com.example.library00.book.domain.ReaderCard;

/**
 * @author lhd
 * @version 1.0
 * @date 2024/3/6 10:23
 */
public interface IReaderCardService {
    boolean readerRegister(ReaderCard readerCard);
    boolean readerLogin(ReaderCard readerCard);
    boolean readerLogout(ReaderCard readerCard);
    boolean rePasswd(long readerId,String newPasswd);
    boolean deleteReaderCard(long readerId);
}
