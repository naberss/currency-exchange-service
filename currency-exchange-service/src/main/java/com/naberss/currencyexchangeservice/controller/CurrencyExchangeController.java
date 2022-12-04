package com.naberss.currencyexchangeservice.controller;

import com.naberss.currencyexchangeservice.model.CurrencyExchange;
import com.naberss.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    CurrencyExchangeRepository repository;
    @Autowired
    private Environment environment;
    @GetMapping(value = "/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

        CurrencyExchange currencyexchange = repository.findByFromAndTo(from, to);
        currencyexchange.setEnvironment(environment.getProperty("server.port"));

        return currencyexchange;
    }
}
