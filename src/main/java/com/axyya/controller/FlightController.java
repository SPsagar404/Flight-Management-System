package com.axyya.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.axyya.entities.Flight;
import com.axyya.service.IFlightService;


@RestController
@RequestMapping("flights")
public class FlightController {
	
	@Autowired
	private IFlightService flightService;
	
	private static final Logger logger = LoggerFactory.getLogger(FlightController.class);
	
	@GetMapping
	public @ResponseBody List<Flight> getAllFlights() {
		return flightService.getAllFlights();
	}
	
	@GetMapping("/{flight-id}")
	public @ResponseBody Flight getFlightById(@PathVariable("flight-id") String flightId) {
		return flightService.getFlightById(flightId);
	}
}
