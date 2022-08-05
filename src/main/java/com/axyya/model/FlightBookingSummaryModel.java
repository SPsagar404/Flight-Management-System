package com.axyya.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightBookingSummaryModel {
	
	private String bookingId;
	private String lastName;
	private String departure;

}
