package pl.otekcode.app.currency.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.otekcode.app.currency.Currency;
import pl.otekcode.app.currency.mapper.CurrencyMapperImpl;
import pl.otekcode.app.exchange.ExchangeServiceImpl;
import pl.otekcode.app.metrics.MetricService;
import pl.otekcode.app.metrics.MetricServiceType;
import pl.otekcode.app.nbp.NBPListCurrencies;
import pl.otekcode.app.nbp.NBPListRate;
import pl.otekcode.app.nbp.NBPServiceImpl;

import java.util.Collection;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CurrencyServiceImpl implements CurrencyService {
    private final NBPServiceImpl nbpService;
    private final CurrencyMapperImpl currencyMapper;

    @Override
    public Collection<String> getAvailableCurrencies() {
        final NBPListCurrencies currencies = nbpService.getCurrencies();
        final Collection<NBPListRate> rates = currencies.getRates();
        return rates.stream().map(NBPListRate::getCode).collect(Collectors.toList());
    }

    @Override
    public Collection<Currency> getCurrencies() {
        final NBPListCurrencies currencies = nbpService.getCurrencies();
        final Collection<NBPListRate> rates = currencies.getRates();
        return currencyMapper.mapFromListDto(rates);

    }
}
