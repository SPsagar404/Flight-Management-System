package com.axyya.entities;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
@Entity
public class Flight {
	
	@Id
	@GeneratedValue(generator = "flight-id-gen")
	@GenericGenerator(name = "flight-id-gen", 
		parameters = @Parameter(name = "prefix", value = "FL"), 
		strategy = "com.axyya.util.StringSequenceIdGenerator")
	private String id;
	private String departure;
	private String arrival;
	private LocalDateTime departureDate;
	private LocalDateTime arrivalDate;
	
	@ManyToMany(mappedBy = "flights", fetch = FetchType.LAZY)
	private Set<Booking> bookings;


}
