package com.axyya.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axyya.entities.Flight;

public interface IFlightRepository extends JpaRepository<Flight, String>{
	
	List<Flight> findByDepartureAndDepartureDateGreaterThan(String departure, LocalDateTime departureDate);

}
