package com.tanvir.Currency;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="forex-service")
@RibbonClient(name="forex-service")
public interface CurrencyProxy {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public Currency retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
