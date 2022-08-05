package com.axyya.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axyya.entities.Booking;

public interface IBookingRepository extends JpaRepository<Booking, String> {

	List<Booking> findByPassengerId(String passengerId);
}
