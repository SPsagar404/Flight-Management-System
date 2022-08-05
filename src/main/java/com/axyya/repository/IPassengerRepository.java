package com.axyya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axyya.entities.Passenger;

public interface IPassengerRepository  extends JpaRepository<Passenger, String>{

}
