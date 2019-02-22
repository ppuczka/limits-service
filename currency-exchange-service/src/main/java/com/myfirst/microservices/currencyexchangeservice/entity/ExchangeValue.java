package com.myfirst.microservices.currencyexchangeservice.entity;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Table(name = "exchange_value")
public class ExchangeValue {

	@PrimaryKeyColumn(name = "id")
	private Long id;
	@PrimaryKeyColumn(name = "from")
	private String from;
	@PrimaryKeyColumn(name = "to")
	private String to;
	@PrimaryKeyColumn(name = "conversion_multiple")
	private BigDecimal conversionMultiple;
	@Column(name = "port")
	private Integer port;

	public ExchangeValue(long id, String from, String to, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}
}
