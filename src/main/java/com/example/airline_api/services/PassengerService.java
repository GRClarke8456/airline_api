package com.example.airline_api.services;

import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {
    @Autowired
    PassengerRepository passengerRepository;

    public List<Passenger> displayPassengers(){
        return passengerRepository.findAll();
    }

    public Optional<Passenger> findPassengerById (long id){
        return passengerRepository.findById(id);
    }

    public Passenger addNewPassenger (Passenger passenger){
        passengerRepository.save(passenger);
        return passenger;
    }

//    public Passenger bookPassengerOntoFlight(Passenger passenger, Long id){
//        Passenger bookPassenger = passengerRepository.findById(id).get();
//        bookPassenger.setName(passenger.getName());
//        bookPassenger.setEmail(passenger.getEmail());
//        bookPassenger.setFlights(passenger.getFlights());
//        passengerRepository.save(bookPassenger);
//        return bookPassenger;
//    }

}
