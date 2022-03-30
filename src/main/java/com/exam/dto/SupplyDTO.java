package com.exam.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplyDTO {

    private String productId;
    private LocalDateTime updateTimeStamp;
    private Double quantity;
    private String status;
}
