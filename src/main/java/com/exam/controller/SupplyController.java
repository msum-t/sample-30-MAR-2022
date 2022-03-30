package com.exam.controller;

import com.exam.domain.Supply;
import com.exam.dto.SupplyDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/updateSupply")
@Slf4j
public class SupplyController {


    @PostMapping
    public ResponseEntity<SupplyDTO> updateSupply(@RequestBody SupplyDTO supplyDTO){

        log.info("update supply controller started");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSX");
        Supply supply1=new Supply("Product1", LocalDateTime.parse("2021-03-16T08:53:48.616Z".replace("T"," "),format),10.0);

        Supply supply2=new Supply ("Product2",LocalDateTime.parse("2021-03-16T08:59:48.616Z".replace("T"," "),format),5.0);

        Supply supply3=new Supply ("Product3",LocalDateTime.parse("2021-03-16T09:10:48.616Z".replace("T"," "),format),30.0);

        Supply supply4=new  Supply ("Product4",LocalDateTime.parse("2021-03-16T09:10:48.616Z".replace("T"," "),format),20.0);
        List<Supply> supplies = List.of(supply1, supply2, supply3, supply4);
        boolean b = supplies.stream().filter(fil -> supplyDTO.getProductId().equals(fil.getProductId()))
                .allMatch(supply -> supplyDTO.getUpdateTimeStamp().isAfter(supply.getUpdateTimeStamp()));


        if(!b){
            supplyDTO.setStatus("Out Of Sync Update");
        }
        else {
            Supply next = supplies.stream().filter(fil -> supplyDTO.getProductId().equals(fil.getProductId())).iterator().next();
            supplyDTO.setQuantity(next.getQuantity()+supplyDTO.getQuantity());
            supplyDTO.setStatus("Updated");
        }
        log.info("update supply controller completed");
        return ResponseEntity.ok(supplyDTO);


    }
}
