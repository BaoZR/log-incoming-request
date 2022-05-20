package com.baeldung.web.log2.service;

import com.baeldung.web.log2.data.TaxiRide;
import org.springframework.stereotype.Service;

@Service
public class TaxiFareCalculatorService {

    public String calculateFare(TaxiRide taxiRide) {
        return String.valueOf((Long) (taxiRide.getIsNightSurcharge()
          ? taxiRide.getDistanceInMile() * 10 + 100
          : taxiRide.getDistanceInMile() * 10));
    }
}
