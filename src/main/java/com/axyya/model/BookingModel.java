package com.axyya.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingModel {
	
	private String id;
	private PassengerModel passenger;
	private List<FlightModel> flights;


}
