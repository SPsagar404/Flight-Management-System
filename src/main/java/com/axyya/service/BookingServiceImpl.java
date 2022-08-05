package com.axyya.service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.axyya.entities.Booking;
import com.axyya.entities.Flight;
import com.axyya.entities.Passenger;
import com.axyya.exception.BookingNotFoundException;
import com.axyya.exception.BookingNotFoundForPassengerException;
import com.axyya.repository.IBookingRepository;
import com.axyya.repository.IFlightRepository;
import com.axyya.repository.IPassengerRepository;

@Service
public class BookingServiceImpl implements IBookingService {
	
	private static final Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);

	@Autowired
	private IBookingRepository bookingRepo;

	@Autowired
	private IPassengerRepository passengerRepo;

	@Autowired
	private IFlightRepository flightRepo;

	@Override
	public Booking getBooking(String bookingId) {
		return bookingRepo.findById(bookingId).orElseThrow(() -> new BookingNotFoundException(bookingId));
	}

	@Override
	public List<Booking> getAllBookingsByPassenger(String passengerId) {
		List<Booking> bookings = bookingRepo.findByPassengerId(passengerId);
		if (CollectionUtils.isEmpty(bookings))
			throw new BookingNotFoundForPassengerException(passengerId);
		return bookings;
	}

	@Override
	@Transactional
	public void createSampleBookings() {
		List<Passenger> allPassengers = passengerRepo.findAll();
		// Stream<Passenger> allPassengers =
		// passengerRepo.findAllByFirstName("Archie").stream();
		// Stream<Passenger> allPassengers = passengerRepo.streamAll();

		// allPassengers.forEach(System.out::println);

		// List<Flight> allFlights = flightRepo.findAll();
		// allFlights.stream().

		final Random flightSelector = new Random(1);

		int[] passCounter = new int[1];

		allPassengers.stream().forEach(passenger -> {

			createRandomBooking(passenger, flightSelector);

			if (passCounter[0] % 3 == 0) {
				createRandomBooking(passenger, flightSelector);
			}

			passCounter[0]++;
		});
	}

	private void createRandomBooking(Passenger passenger, Random flightSelector) {
		String flightID = "FL-" + (flightSelector.nextInt(19) + 1);
		logger.debug(">>>>>>>>>>>>>>> FL-ID = " + flightID);
		Flight flight = flightRepo.findById(flightID).orElse(null);
		logger.debug(">>>>>>>>>>>>>>>>>> Flight = " + flight);

		List<Flight> nextFlights = flightRepo.findByDepartureAndDepartureDateGreaterThan(flight.getArrival(),
				flight.getArrivalDate());
		Flight nextFlight = CollectionUtils.isEmpty(nextFlights) ? null : nextFlights.get(0);
		logger.debug(" CCCCCCCCCCCC >>>>>>>>>>>>>>>>>> nextFlight = " + nextFlight);

		Booking booking = new Booking();
		booking.setPassenger(passenger);

		Set<Flight> flights = new HashSet<>(2);
		flights.add(flight);
		if (CollectionUtils.isEmpty(flight.getBookings())) {
			flight.setBookings(new HashSet<>(2));
		}
		flight.getBookings().add(booking);
		if (nextFlight != null) {
			flights.add(nextFlight);
			if (CollectionUtils.isEmpty(nextFlight.getBookings())) {
				nextFlight.setBookings(new HashSet<>(2));
			}
			nextFlight.getBookings().add(booking);
		}
		booking.setFlights(flights);
		bookingRepo.save(booking);
		flightRepo.save(flight);

		flightRepo.save(flight);
		if (nextFlight != null) {
			flightRepo.save(nextFlight);
		}
	}

	@Override
	public List<Booking> getAllMultiFlightBookingsByPassenger(String passengerId) {
		List<Booking> bookings = bookingRepo.findByPassengerId(passengerId);
		return bookings.stream().filter(booking -> booking.getFlights().size() > 1).collect(Collectors.toList());

		/*
		final List<FlightBooking> filteredList = new ArrayList<>();
		if (CollectionUtils.isEmpty(bookings))
			return Collections.EMPTY_LIST;
		
		bookings.stream().forEach(booking -> {
			if(booking.getFlights().size() > 1) {
				filteredList.add(booking);
			}
		});
		
		return filteredList;
*/	}

	@Override
	public List<Booking> getAllMultiFlightBookings() {
		List<Booking> bookings = bookingRepo.findAll();
		
		/*if (CollectionUtils.isEmpty(bookings))
			return Collections.EMPTY_LIST;
		
		bookings.stream().forEach(action);*/
		return bookings;
	}


}
