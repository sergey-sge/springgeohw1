package com.gmail.sge.serejka.springgeohw.json;

import lombok.Data;

@Data
public class Rate {
    private long timestamp;
    private String date;
    private SingleRate rates;
    private String ip;
}