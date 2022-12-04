package com.naberss.currencyexchangeservice.repository;

import com.naberss.currencyexchangeservice.model.currencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface currencyExchangeRepository extends JpaRepository<currencyExchange, Long> {

    public currencyExchange findByFromAndTo(String from, String to);

}
