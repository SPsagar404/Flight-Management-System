package com.axyya.service;

import java.util.List;

import com.axyya.entities.Booking;

public interface IBookingService {
	
	public Booking getBooking(String bookingId);
	
	public List<Booking> getAllBookingsByPassenger(String passengerId);

	public List<Booking> getAllMultiFlightBookingsByPassenger(String passengerId);

	public List<Booking> getAllMultiFlightBookings();
	
	public void createSampleBookings();

}
