package com.exam.controller;

import com.exam.dto.DateByDTO;
import com.exam.domain.Availability;
import com.exam.domain.Capacity;
import com.exam.service.DateByService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

@RestController
@RequestMapping("/getDatesByservice")
public class DateController {

    @Autowired
    private DateByService dateByService;


    public ResponseEntity<DateByDTO> getDatesBy(@RequestBody DateByDTO dateByDTO) throws ExecutionException, InterruptedException {

        CompletableFuture<Availability> availability = dateByService.getAvailability(dateByDTO.getStoreNo(),dateByDTO.getProductId());
        CompletableFuture<Capacity> capacity = dateByService.getCapacity(dateByDTO.getStoreNo(),dateByDTO.getProductId());

//        if (availability.get().getDate().isBefore())
//            ResponseEntity.ok()


        return  null;


    }



}
