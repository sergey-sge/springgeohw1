package com.gmail.sge.serejka.springgeohw.retrievers;

import com.gmail.sge.serejka.springgeohw.json.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RateRetriever {

    private static final String URL = "http://data.fixer.io/api/latest?access_key=";
    private static final String KEY = "a2af8443c66270ec8f0d75dfcad3157c";

    @Autowired
    private CacheManager cacheManager;

    @Cacheable("rates") // Redis
    public Rate getRate() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Rate> response = restTemplate.getForEntity(URL + KEY, Rate.class);
        return response.getBody();
    }

    @Scheduled(fixedRate = 600000)
    public void updateCache(){
        cacheManager.getCache("rates").clear();
        getRate();
    }


}