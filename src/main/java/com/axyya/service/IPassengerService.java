package com.axyya.service;

import java.util.List;

import com.axyya.entities.Passenger;

public interface IPassengerService {
	
	public List<Passenger> getAllPassengers();
	public Passenger getPassengerById(String passengerId);

	

}
