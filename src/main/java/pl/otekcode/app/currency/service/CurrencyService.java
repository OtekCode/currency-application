package pl.otekcode.app.currency.service;

import pl.otekcode.app.currency.Currency;

import java.util.Collection;

public interface CurrencyService {

    Collection<String> getAvailableCurrencies();

    Collection<Currency> getCurrencies();
}
