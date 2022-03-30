package com.exam.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Capacity {
    private String storeNo;
    private String productId;
    private Double noOfOrdersAccepted;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate date;
}
