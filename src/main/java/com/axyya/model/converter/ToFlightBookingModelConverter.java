package com.axyya.model.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.axyya.entities.Booking;
import com.axyya.model.BookingModel;
import com.axyya.model.FlightModel;
import com.axyya.model.PassengerModel;

@Component
public class ToFlightBookingModelConverter implements Converter<Booking,BookingModel> {

	@Override
	public BookingModel convert(Booking source) {
		
		List<FlightModel> flights = new ArrayList<>();

		if (!CollectionUtils.isEmpty(source.getFlights())) {
			source.getFlights().stream().forEach(flight -> {
				flights.add(new FlightModel(flight.getDeparture(), flight.getArrival(),
						flight.getDepartureDate().toString(), flight.getArrivalDate().toString()));
			});
		}

		return new BookingModel(source.getId(), new PassengerModel(source.getPassenger().getFirstName(),
				source.getPassenger().getLastName(), source.getPassenger().getEmail()), flights);
	}

}
