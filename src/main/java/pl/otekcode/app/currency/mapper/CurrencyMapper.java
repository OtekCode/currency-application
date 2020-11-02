package pl.otekcode.app.currency.mapper;

import pl.otekcode.app.currency.Currency;
import pl.otekcode.app.currency.CurrencyInput;

import java.util.Collection;

public interface CurrencyMapper {

    Currency mapFromDto(CurrencyInput dto);

    <T extends CurrencyInput>Collection<Currency> mapFromListDto(Collection<T> list);
}
