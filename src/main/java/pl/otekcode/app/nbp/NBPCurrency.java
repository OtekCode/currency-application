package pl.otekcode.app.nbp;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

public class NBPCurrency {
    private Character table;
    private String no;
    @JsonProperty("currency")
    private String name;
    private String code;
    private Collection<NBPRate> rates;
}
