package pl.otekcode.app.exchange;

import lombok.Getter;

@Getter
public class ExchangeCurrencyNotFoundException extends RuntimeException{
    private final String code;

    public ExchangeCurrencyNotFoundException(String code) {
        this.code = code;
    }
}
