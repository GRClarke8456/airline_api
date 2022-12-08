package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    @Autowired
    FlightRepository flightRepository;

    public List<Flight> displayAllFlights(){
        return flightRepository.findAll();
    }

    public Optional<Flight> findFlightById(long id){
        return flightRepository.findById(id);
    }

    public Flight addNewFlight(Flight flight){
        flightRepository.save(flight);
        return flight;
    }

    public Flight bookPassengerOntoFlight(Flight flight, Long id){
        Flight bookPassenger = flightRepository.findById(id).get();
        bookPassenger.setDestination(flight.getDestination());
        bookPassenger.setCapacity(flight.getCapacity());
        bookPassenger.setDepartureDate(flight.getDepartureDate());
        bookPassenger.setDepartureTime(flight.getDepartureTime());
        bookPassenger.setPassengers(flight.getPassengers());
        flightRepository.save(bookPassenger);
        return bookPassenger;
    }

    public Long cancelFlight(long id){
        flightRepository.deleteById(id);
        return id;
    }

}
