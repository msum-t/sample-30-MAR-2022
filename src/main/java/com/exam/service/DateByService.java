package com.exam.service;

import com.exam.domain.Availability;
import com.exam.domain.Capacity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class DateByService {


    @Async
    public CompletableFuture<Availability> getAvailability(String storeNo, String productId) {
        Availability availability1=Availability.builder().storeNo("Store001").date(LocalDate.parse("2021-10-29")).productId("Prod1").availQty(1.0).build();
        Availability availability2=Availability.builder().storeNo("Store001").date(LocalDate.parse("2021-10-26")).productId("Prod1").availQty(3.0).build();
        Availability availability3=Availability.builder().storeNo("Store001").date(LocalDate.parse("2021-10-25")).productId("Prod1").availQty(0.0).build();
        List<Availability> availabilityList= List.of(availability1,availability2,availability3);
        log.info("Availability thread name {}"  , Thread.currentThread().getName());
        return CompletableFuture
                .completedFuture(availabilityList
                .stream()
                .filter(availability -> availability.getStoreNo().equals(storeNo))
                        .filter(availability -> availability.getProductId().equals(productId)).iterator().next());
    }


    @Async
    public CompletableFuture<Capacity> getCapacity(String storeNo,String productId) {
        Capacity capacity1=Capacity.builder().storeNo("Store001").productId("Prod1").date(LocalDate.parse("2021-02-19")).noOfOrdersAccepted(0.0).build();
        Capacity capacity2= Capacity.builder().storeNo("Store001").productId("Prod1").date(LocalDate.parse("2021-02-20")).noOfOrdersAccepted(2.0).build();
        Capacity capacity3=Capacity.builder().storeNo("Store001").productId("Prod1").date(LocalDate.parse("2021-02-21")).noOfOrdersAccepted(2.0).build();
        Capacity capacity4=Capacity.builder().storeNo("Store001").productId("Prod1").date(LocalDate.parse("2021-02-22")).noOfOrdersAccepted(0.0).build();
        List<Capacity> capacityList=List.of(capacity1,capacity2,capacity3,capacity2);
        log.info("Capacity thread name {}"  , Thread.currentThread().getName());
        return CompletableFuture.completedFuture(capacityList.stream()
                .filter(capacity -> capacity.getStoreNo().equals(storeNo))
                .filter(availability -> availability.getProductId().equals(productId)).iterator().next());

    }

}
