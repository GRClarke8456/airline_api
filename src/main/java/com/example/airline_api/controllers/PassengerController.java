package com.example.airline_api.controllers;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.PassengerRepository;
import com.example.airline_api.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    @Autowired
    PassengerRepository passengerRepository;

    // Display details of all passengers
    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers(){
        return new ResponseEntity<>(passengerService.displayPassengers(), HttpStatus.OK);
    }


    // Display specific passenger details
    @GetMapping(value = "/{id}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable long id){
        return new ResponseEntity<>(passengerService.findPassengerById(id).get(), HttpStatus.OK);
    }

    // Add a new passenger
    @PostMapping
    public ResponseEntity<Passenger> addNewPassenger(@RequestBody Passenger passenger){
        passengerService.addNewPassenger(passenger);
        return new ResponseEntity<>(passenger, HttpStatus.CREATED);
    }

//    @PatchMapping(value = "/{id}")
//    public ResponseEntity<Passenger> addPassengerToFlight(@RequestBody Passenger passenger, @PathVariable long id){
//        Passenger bookPassenger = passengerService.bookPassengerOntoFlight(passenger, id);
//        passengerRepository.save(bookPassenger);
//        return new ResponseEntity<>(bookPassenger, HttpStatus.OK);
//    }
}
