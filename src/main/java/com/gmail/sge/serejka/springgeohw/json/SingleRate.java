package com.gmail.sge.serejka.springgeohw.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SingleRate {
    @JsonProperty("UAH")
    private double uah;
}
