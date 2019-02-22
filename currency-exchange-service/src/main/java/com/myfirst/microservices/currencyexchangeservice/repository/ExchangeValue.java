package com.myfirst.microservices.currencyexchangeservice.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeValue extends CassandraRepository<ExchangeValue, Long> {



}
