package com.example.library00.book.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author lhd
 * @version 1.0
 * @date 2024/3/9 15:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BackBookDTO {
    @NotNull(message = "bookId is null")
    private long bookId;

}
