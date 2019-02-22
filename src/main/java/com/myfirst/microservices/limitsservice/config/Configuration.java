package com.myfirst.microservices.limitsservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("bootstrap")
@Data
public class Configuration {

	private Integer min;
	private Integer max;


}
