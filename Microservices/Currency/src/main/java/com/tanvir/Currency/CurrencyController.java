package com.tanvir.Currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyController {
    @Autowired
    private CurrencyProxy proxy;
    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public Currency convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
//        Map<String , String> uriMap = new HashMap<>();
//        uriMap.put("from", from);
//        uriMap.put("to", to);
//        ResponseEntity<Currency>  responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", Currency.class,
//                uriMap);
//        Currency response = responseEntity.getBody();
          Currency response = proxy.retrieveExchangeValue(from, to);
        return  new Currency(response.getId(), from, to, response.getConversionMultiple(), quantity, quantity.multiply(response.getConversionMultiple()), response.getPort());
    }

}
