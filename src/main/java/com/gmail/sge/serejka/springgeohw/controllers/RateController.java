package com.gmail.sge.serejka.springgeohw.controllers;



import com.gmail.sge.serejka.springgeohw.dto.LocationDTO;
import com.gmail.sge.serejka.springgeohw.json.Rate;
import com.gmail.sge.serejka.springgeohw.retrievers.GeoRetriever;
import com.gmail.sge.serejka.springgeohw.retrievers.RateRetriever;
import com.gmail.sge.serejka.springgeohw.services.LocationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RateController {
    private final RateRetriever rateRetriever;
    private final GeoRetriever geoRetriever;
    private final LocationService locationService;

    public RateController(RateRetriever rateRetriever, GeoRetriever geoRetriever,
                          LocationService locationService) {
        this.rateRetriever = rateRetriever;
        this.geoRetriever = geoRetriever;
        this.locationService = locationService;
    }

    @GetMapping("/rate")
    public Rate rate(HttpServletRequest request) { // Jackson
        String ip = request.getRemoteAddr();

        LocationDTO location = geoRetriever.getLocation(ip);
        locationService.save(location);
        Rate rate = rateRetriever.getRate();
        rate.setIp(ip);
        return rate;
    }
}

