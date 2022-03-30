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
public class Availability {

    private String storeNo;
    private String productId;
    private Double availQty;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate date;
}
