package com.example.library00.book.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author lhd
 * @version 1.0
 * @date 2024/3/4 23:21
 */
@Getter
@Setter
public class ReaderCard implements Serializable {
    private long readerId;
    private String name;
    private String passwd;
    private String card_state;
}
