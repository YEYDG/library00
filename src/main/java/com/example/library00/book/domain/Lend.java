package com.example.library00.book.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lhd
 * @version 1.0
 * @date 2024/3/9 13:35
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("lend_list")
public class Lend implements Serializable {

    @TableId("sernum")
    private Long sernum;

    @TableField("book_id")
    private long bookId;

    @TableField("reader_id")
    private long readerId;

    @TableField("lend_date")
    private Date lendDate;

    @TableField("back_date")
    private Date backDate;

}
