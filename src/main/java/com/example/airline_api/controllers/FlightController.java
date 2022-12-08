package com.example.airline_api.controllers;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import com.example.airline_api.services.FlightService;
import com.example.airline_api.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    @Autowired
    FlightRepository flightRepository;


    // Display all available flights
//    @GetMapping
//    public ResponseEntity<List<Flight>> getAllFlights(){
//        return new ResponseEntity<>(flightService.displayAllFlights(), HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights(
            @RequestParam(required = false, name = "destination") String destination
    ){
        if (destination != null){
            return new ResponseEntity<>(flightRepository.findByDestination(destination), HttpStatus.OK);
        }
        return new ResponseEntity<>(flightService.displayAllFlights(), HttpStatus.OK);
    }

    // Display a specific flight
    @GetMapping(value = "/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable long id){
        return new ResponseEntity<>(flightService.findFlightById(id).get(), HttpStatus.OK);
    }

    // Add details of a new flight
    @PostMapping
    public ResponseEntity<Flight> addNewFlight(@RequestBody Flight flight){
        flightService.addNewFlight(flight);
        return new ResponseEntity<>(flight, HttpStatus.CREATED);
    }

    // Book passenger on a flight
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Flight> addPassengerToFlight(@RequestBody Flight flight, @PathVariable long id){
        Flight bookPassenger = flightRepository.findById(id).get();
        bookPassenger.setDestination(flight.getDestination());
        bookPassenger.setCapacity(flight.getCapacity());
        bookPassenger.setDepartureDate(flight.getDepartureDate());
        bookPassenger.setDepartureTime(flight.getDepartureTime());
        bookPassenger.setPassengers(flight.getPassengers());
        flightRepository.save(bookPassenger);
        return new ResponseEntity<>(bookPassenger, HttpStatus.OK);
    }

    // Cancel flight
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> cancelFlight(@PathVariable long id){
        return new ResponseEntity<>(flightService.cancelFlight(id), HttpStatus.OK);
    }

}
