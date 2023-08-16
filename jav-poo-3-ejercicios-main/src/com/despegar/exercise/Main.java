package com.despegar.exercise;

import com.despegar.exercise.common.Passenger;
import com.despegar.exercise.common.PassengerType;
import com.despegar.exercise.flight.Flight;
import com.despegar.exercise.flight.FlightProvider;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

    private static final Collection<Passenger> simpsons = simpsons();
    private static final Collection<Passenger> flanders = flanders();
    private static final LocalDate departure = LocalDate.of(2023, 12, 1);
    private static final String from = "BUE";
    private static final String to = "MIA";
    private static final FlightProvider flightProvider = new FlightProvider();
    private static final Flight flight = startFlight(100L, 21L);
    private static final Flight cheaperFlight = startFlight(50L, 10L);
    private static final Flight expensiveFlight = startFlight(150L, 30L);


    public static void main(String[] args) {
        a();
        b();
        c();
        d();
    }

    private static Flight startFlight(long base, long tax) {
        return new Flight(
                from,
                to,
                departure,
                BigDecimal.valueOf(base),
                BigDecimal.valueOf(tax));
    }

    private static Collection<Passenger> simpsons() {
        Collection<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger("Homero Simpson", PassengerType.ADULT));
        passengers.add(new Passenger("Marge Simpson", PassengerType.ADULT));
        passengers.add(new Passenger("Bart Simpson", PassengerType.CHILD));
        passengers.add(new Passenger("Lisa Simpson", PassengerType.CHILD));
        passengers.add(new Passenger("Maggie Simpson", PassengerType.INFANT));
        return passengers;
    }

    private static Collection<Passenger> flanders() {
        Collection<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger("Ned Flanders", PassengerType.ADULT));
        passengers.add(new Passenger("Maude Flanders", PassengerType.ADULT));
        passengers.add(new Passenger("Rod Flanders", PassengerType.CHILD));
        passengers.add(new Passenger("Todd Flanders", PassengerType.CHILD));
        return passengers;
    }


    /**
     * (A)
     * This method will test the method search of FlightProvider
     */
    private static void a() {
        flightProvider.addFlight(flight, 4);
        // Execute Search
        Collection<Flight> searchResult = flightProvider.search("BUE", "MIA", departure, simpsons);

        // Validate
        validateTrue(searchResult != null && searchResult.contains(flight),
                "(A) Search Result",
                "Search result does not contain the expected flight");
        validateTrue(flightProvider.amountOfFlightsAvailable() == 1,
                "(A) Available Flights",
                "Search should not remove the available flight.");
        validateTrue(flightProvider.availableSeats(flight) == 4,
                "(A) Available Seats",
                "Available seats for the flight not booked should be 4.");
    }

    /**
     * (B)
     * This method will test the method book of FlightProvider. It will also use Search.
     */
    private static void b() {
        // Execute Book
        flightProvider.book(flight, simpsons);
        Collection<Flight> searchResult = flightProvider.search("BUE", "MIA", departure, simpsons);

        // Validate
        validateTrue(flightProvider.amountOfFlightsAvailable() == 0,
                "(B) Book",
                "Book flight that takes all available seats should leave no available flights");
        validateTrue(searchResult != null && searchResult.isEmpty(),
                "(B) Search Result",
                "Search result should be empty after all available seats were booked.");
        validateTrue(flightProvider.availableSeats(flight) == 0,
                "(B) Available Seats",
                "Available seats for a non existing flight should be 0.");
    }

    private static void c() {
        // Validate
        validateTrue(flight.totalPrice(simpsons).equals(BigDecimal.valueOf(405L)),
                "(C) Flight Total Price",
                "Flight total price is wrong. It should be $405 for the Simpsons.");
        validateTrue(flight.totalPrice(flanders).equals(BigDecimal.valueOf(384L)),
                "(C) Flight Total Price",
                "Flight total price is wrong. It should be $384 for the Flanders.");
    }

    private static void d() {
        flightProvider.addFlight(flight, 4);
        flightProvider.addFlight(cheaperFlight, 4);
        flightProvider.addFlight(expensiveFlight, 4);

        // Execute Search
        List<Flight> searchResult = flightProvider.searchOrderByPrice("BUE", "MIA", departure, flanders);

        // Validate
        validateTrue(searchResult != null &&
                        searchResult.contains(flight) &&
                        searchResult.contains(cheaperFlight) &&
                        searchResult.contains(expensiveFlight),
                "(D) Search Result Contains",
                "Search result should contain all flights");
        validateTrue(searchResult != null &&
                        searchResult.size() == 3 &&
                        searchResult.get(0).equals(cheaperFlight) &&
                        searchResult.get(1).equals(flight) &&
                        searchResult.get(2).equals(expensiveFlight),
                "(D) Search Result Order",
                "Search result order should have the cheapest flight first and the expensive flight last.");
    }

    private static void validateTrue(boolean value,
                                     String exerciseName,
                                     String errorMessage) {
        if (value)
            System.out.println("OK - " + exerciseName);
        else
            System.out.println("ERROR - " + exerciseName + " - " + errorMessage);
    }
}
