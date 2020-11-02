package pl.otekcode.app.exchange;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.otekcode.app.currency.Currency;
import pl.otekcode.app.currency.service.CurrencyServiceImpl;
import pl.otekcode.app.metrics.MetricServiceImpl;
import pl.otekcode.app.metrics.MetricServiceType;
import pl.otekcode.app.nbp.NBPClient;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ExchangeServiceImpl implements ExchangeService {
    private final CurrencyServiceImpl currencyService;
    private final MetricServiceImpl metricService;
    @Override
    public ExchangeResult exchange(String from, String to, double money) {
        final Collection<Currency> currencies = currencyService.getCurrencies();
        final Currency first = findCurrency(currencies, from).orElseThrow((Supplier<RuntimeException>) () -> new ExchangeCurrencyNotFoundException(from));
        final Currency second = findCurrency(currencies, to).orElseThrow((Supplier<RuntimeException>) () -> new ExchangeCurrencyNotFoundException(to));
        final double asked = money*first.getAsk();
        final double value = asked/second.getBid();
        return ExchangeResult.builder().from(first).to(second).result(value).build();
    }

    private Optional<Currency> findCurrency(Collection<Currency> currencies, String code){
        return currencies.stream().filter(currency -> currency.getCode().equalsIgnoreCase(code)).findFirst();
    }
}
