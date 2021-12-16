package com.ouertani.microservices.limitsservice.controller;

import com.ouertani.microservices.limitsservice.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ouertani.microservices.limitsservice.bean.Limits;

@RestController
public class LimitsController {

	private final Configuration configuration;

	@Autowired
	public LimitsController(Configuration configuration) {
		this.configuration = configuration;
	}

	@GetMapping("/limits")
	public Limits retrieveLimits() {
		return new Limits(configuration.getMinimum(), configuration.getMaximum());
	}
}