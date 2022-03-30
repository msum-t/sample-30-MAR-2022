package com.exam.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DateByDTO {

    private String storeNo;
    private String productId;
    private Integer reqQty;
    private LocalDate EDD;

}
