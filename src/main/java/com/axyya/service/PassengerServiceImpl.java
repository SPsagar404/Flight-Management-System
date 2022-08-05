package com.axyya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axyya.entities.Passenger;
import com.axyya.exception.PassengerNotFoundException;
import com.axyya.repository.IPassengerRepository;

@Service
public class PassengerServiceImpl implements IPassengerService{
	
	@Autowired
	private IPassengerRepository passengerRepo;

	@Override
	public Passenger getPassengerById(String passengerId) {
		return passengerRepo.findById(passengerId).orElseThrow(() -> new PassengerNotFoundException(passengerId));
	}

	@Override
	public List<Passenger> getAllPassengers() {
		return passengerRepo.findAll();
	}

}
