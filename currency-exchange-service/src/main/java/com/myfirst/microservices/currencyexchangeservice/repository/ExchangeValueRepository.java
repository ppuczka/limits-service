package com.myfirst.microservices.currencyexchangeservice.repository;

import com.myfirst.microservices.currencyexchangeservice.entity.ExchangeValue;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExchangeValueRepository extends CassandraRepository<ExchangeValue, Integer> {

    ExchangeValue findBy(final Integer id);
 }
