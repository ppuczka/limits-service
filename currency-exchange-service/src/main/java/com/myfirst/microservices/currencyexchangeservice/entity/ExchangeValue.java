package com.myfirst.microservices.currencyexchangeservice.entity;

import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.math.BigDecimal;

@Data
@Table("exchange_value")
public class ExchangeValue {

	@PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED)
	private Integer id;
	@PrimaryKeyColumn(name = "from")
	private String from;
	@PrimaryKeyColumn(name = "to")
	private String to;
	@PrimaryKeyColumn(name = "conversion_multiple")
	private BigDecimal conversionMultiple;
	@Column("port")
	private Integer port;

	public ExchangeValue(Integer id, String from, String to, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}
}
