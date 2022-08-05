package com.axyya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axyya.entities.Flight;
import com.axyya.exception.FlightNotFoundException;
import com.axyya.repository.IFlightRepository;

@Service
public class FlightServiceImpl implements IFlightService{
	
	@Autowired
	private IFlightRepository flightRepo;

	@Override
	public Flight getFlightById(String flightId) {
		return flightRepo.findById(flightId).orElseThrow(() -> new FlightNotFoundException(flightId));
	}

	@Override
	public List<Flight> getAllFlights() {
		return flightRepo.findAll();
	}

}
