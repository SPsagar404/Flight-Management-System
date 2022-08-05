package com.axyya.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightModel {

	private String departure;
	private String arrival;
	private String departureDate;
	private String arrivalDate;
}
