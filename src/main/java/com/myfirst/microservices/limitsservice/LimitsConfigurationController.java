package com.myfirst.microservices.limitsservice;

import com.myfirst.microservices.limitsservice.beans.LimitConfiguration;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public LimitConfiguration retriveLimitfFromConfiguration(){
		return new LimitConfiguration(configuration.getMin(),configuration.getMax());
	}
}
