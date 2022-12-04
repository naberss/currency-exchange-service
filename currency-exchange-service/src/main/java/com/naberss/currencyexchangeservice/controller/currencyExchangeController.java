package com.naberss.currencyexchangeservice.controller;

import com.naberss.currencyexchangeservice.model.currencyExchange;
import com.naberss.currencyexchangeservice.repository.currencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class currencyExchangeController {

    @Autowired
    currencyExchangeRepository repository;
    @Autowired
    private Environment environment;
    @GetMapping(value = "/currency-exchange/from/{from}/to/{to}")
    public currencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

        currencyExchange currencyexchange = repository.findByFromAndTo(from, to);
        currencyexchange.setEnviroment(environment.getProperty("server.port"));

        return currencyexchange;
    }
}
