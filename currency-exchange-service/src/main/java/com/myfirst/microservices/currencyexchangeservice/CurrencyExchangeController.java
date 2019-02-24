package com.myfirst.microservices.currencyexchangeservice;

import com.datastax.driver.core.ResultSet;
import com.myfirst.microservices.currencyexchangeservice.entity.ExchangeValue;
import com.myfirst.microservices.currencyexchangeservice.repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class   CurrencyExchangeController {

	@Autowired
	private Environment environment;

	@Autowired
	private ExchangeValueRepository repository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retriveExchangeValue(@PathVariable String from, @PathVariable String to) {
	ExchangeValue exchangeValue = repository.findBy(2);
	exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
	return exchangeValue;
	}


}