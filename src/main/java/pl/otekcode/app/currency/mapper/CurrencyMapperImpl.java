package pl.otekcode.app.currency.mapper;

import org.springframework.stereotype.Component;
import pl.otekcode.app.currency.Currency;
import pl.otekcode.app.currency.CurrencyInput;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class CurrencyMapperImpl implements CurrencyMapper{
    @Override
    public final Currency mapFromDto(CurrencyInput dto) {
        return Currency
                .builder()
                .name(dto.getName())
                .code(dto.getCode())
                .ask(dto.getAsk())
                .bid(dto.getBid()).build();
    }

    public <T extends CurrencyInput> Collection<Currency> mapFromListDto(Collection<T> list) {
        return list.stream().map(this::mapFromDto).collect(Collectors.toList());
    }
}
