package com.myfirst.microservises.currencyconversionservcice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class CurrencyConversionBean {

        private Long id;
        private String from;
        private String to;
        private BigDecimal conversionMultiple;
        private BigDecimal quantity;
        private BigDecimal totalCalculatedAmount;
        private int port;


}
