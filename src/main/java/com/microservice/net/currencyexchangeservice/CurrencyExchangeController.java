package com.microservice.net.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @Autowired
    private Environment environment;
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to ){
        String port = environment.getProperty("local.server.port");
        CurrencyExchange response = currencyExchangeRepository.findByFromAndTo(from, to);
        if(response == null){
            throw new RuntimeException("Unable to find data from {} to {}" + from + "-" + to);
        }
        response.setEnvironment(port);
        return response;
        //return new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(50), port);
    }
}
