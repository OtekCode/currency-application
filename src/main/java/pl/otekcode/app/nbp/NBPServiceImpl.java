package pl.otekcode.app.nbp;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.otekcode.app.metrics.MetricServiceImpl;
import pl.otekcode.app.metrics.MetricServiceType;

@Service
@RequiredArgsConstructor(onConstructor=@__(@Autowired))
public class NBPServiceImpl implements NBPService{
    private final NBPClient nbpClient;
    private final MetricServiceImpl metricService;


    @Override
    public NBPListCurrencies getCurrencies() {
        final NBPListCurrencies currencies = nbpClient.getCurrencies().stream().findFirst().orElseThrow(IllegalStateException::new);
        metricService.saveMetric("http://api.nbp.pl/api/exchangerates/tables/C","GET",NBPClient.class.getSimpleName(),"getCurrencies", MetricServiceType.EXTERNAL);
        return currencies;
    }
}
