package pl.otekcode.app.nbp;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@FeignClient(name = "nbp-client",url = "http://api.nbp.pl/api")
public interface NBPClient {

    @RequestMapping(method = RequestMethod.GET, value = "/exchangerates/tables/C")
    Collection<NBPListCurrencies> getCurrencies();

}
