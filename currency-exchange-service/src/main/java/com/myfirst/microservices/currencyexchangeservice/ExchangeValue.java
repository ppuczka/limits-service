package com.myfirst.microservices.currencyexchangeservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeValue {

	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
}
