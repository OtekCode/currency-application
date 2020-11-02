package pl.otekcode.app.exchange;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.otekcode.app.metrics.MetricService;
import pl.otekcode.app.metrics.MetricServiceType;

@RestController
@RequestMapping("/exchange")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ExchangeController {
    private final ExchangeServiceImpl exchangeService;
    private final MetricService metricService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<ExchangeResult> exchange(@RequestBody ExchangeDto dto) {
        final ExchangeResult result = exchangeService.exchange(dto.getFrom(), dto.getTo(), dto.getValue());
        metricService.saveMetric("/exchange", "POST", ExchangeServiceImpl.class.getSimpleName(), "exchange", MetricServiceType.LOCAL);
        return ResponseEntity.ok(result);
    }
}
