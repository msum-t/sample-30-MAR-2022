package com.exam.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Supply {
   private String productId;
    private LocalDateTime updateTimeStamp;
    private Double quantity;

    public Supply(String productId, LocalDateTime updateTimeStamp, Double quantity) {
        this.productId = productId;
        this.updateTimeStamp = updateTimeStamp;
        this.quantity = quantity;
    }

    public Supply() {
    }
}
