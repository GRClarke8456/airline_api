package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Dataloader implements ApplicationRunner {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightRepository flightRepository;

    public Dataloader(){}

    @Override
    public void run(ApplicationArguments args) throws Exception{

//        Create 5 Flights
        Flight ba101 = new Flight("Tokyo", 320, "09/12/22", "09:45");


        flightRepository.save(ba101);

        Flight ba321 = new Flight("Seoul", 260, "25/12/22", "19:30");
        flightRepository.save(ba321);

        Flight klm567 = new Flight("Amsterdam", 70, "01/01/23", "08:50");

        flightRepository.save(klm567);

        Flight af987 = new Flight("Paris", 70, "29/12/22", "15:00");

        flightRepository.save(af987);

        Flight af654 = new Flight("Taipei", 300, "03/01/23", "10:00");
        flightRepository.save(af654);


//        Create 10 Passengers
        Passenger georgia = new Passenger("Georgia", "G84@gmail.com");
//        georgia.bookPassengerOnFlight(ba101);
        passengerRepository.save(georgia);

        Passenger harriet = new Passenger("Harriet", "Har@gmail.com");
//        harriet.bookPassengerOnFlight(af987);
        passengerRepository.save(harriet);

        Passenger rita = new Passenger("Rita", "R@hotmail.uk");
        passengerRepository.save(rita);

        Passenger dylan = new Passenger("Dylan", "Stiles@tw.us");
        passengerRepository.save(dylan);

        Passenger rochelle = new Passenger("Rochelle", "rocxx@live.uk");
        passengerRepository.save(rochelle);

        Passenger shirogane = new Passenger("Takeshi", "BlackPaladin@vol.tron");
//        shirogane.bookPassengerOnFlight(ba101);
        passengerRepository.save(shirogane);

        Passenger mcclain = new Passenger("Lance", "BluePaladin@vol.tron");
//        mcclain.bookPassengerOnFlight(klm567);
        passengerRepository.save(mcclain);

        Passenger kogane = new Passenger("Keith", "RedPaladin@vol.tron");
        passengerRepository.save(kogane);

        Passenger hunk = new Passenger("Hunk", "YellowPaladin@vol.tron");
        passengerRepository.save(hunk);

        Passenger pidge = new Passenger("Pidge", "GreenPaladin@vol.tron");
        passengerRepository.save(pidge);

    }
}
