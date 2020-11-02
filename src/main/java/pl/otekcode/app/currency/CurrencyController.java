package pl.otekcode.app.currency;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.otekcode.app.currency.service.CurrencyServiceImpl;
import pl.otekcode.app.metrics.MetricService;
import pl.otekcode.app.metrics.MetricServiceType;

import java.util.Collection;

@RestController
@RequestMapping("/currency")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class CurrencyController {
    private final CurrencyServiceImpl service;
    private final MetricService metricService;

    @RequestMapping(method = RequestMethod.GET, value = "/available")
    public ResponseEntity<Collection<String>> getAvailableCurrencies() {
        final Collection<String> availableCurrencies = service.getAvailableCurrencies();
        metricService.saveMetric("/currencies/available","GET", CurrencyServiceImpl.class.getSimpleName(),"getAvailableCurrencies", MetricServiceType.LOCAL);
        return ResponseEntity.ok(availableCurrencies);
    }

    @RequestMapping(method = RequestMethod.GET, value = "")
    public ResponseEntity<Collection<Currency>> getCurrencies() {
        final Collection<Currency> currencies = service.getCurrencies();
        metricService.saveMetric("/currencies","GET", CurrencyServiceImpl.class.getSimpleName(),"getCurrencies", MetricServiceType.LOCAL);
        return ResponseEntity.ok(currencies);
    }
}
