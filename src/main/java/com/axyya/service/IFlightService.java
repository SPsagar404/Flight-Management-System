package com.axyya.service;

import java.util.List;

import com.axyya.entities.Flight;

public interface IFlightService {
	
	public Flight getFlightById(String flightId);

	public List<Flight> getAllFlights();

}
