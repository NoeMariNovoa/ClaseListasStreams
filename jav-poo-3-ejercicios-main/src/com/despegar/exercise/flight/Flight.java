package com.despegar.exercise.flight;

import com.despegar.exercise.common.Passenger;
import com.despegar.exercise.common.PassengerType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

public class Flight {
    private final String from;
    private final String to;
    private final LocalDate departure;
    private final BigDecimal basePrice;
    private final BigDecimal taxByPassenger;

    public Flight(String from, String to, LocalDate departure, BigDecimal basePrice, BigDecimal taxByPassenger) {
        this.from = from;
        this.to = to;
        this.departure = departure;
        this.basePrice = basePrice;
        this.taxByPassenger = taxByPassenger;
    }

    /**
     *      TODO (C)
     * Total price is obtained by:
     * ADULT TOTAL PRICE  = (basePrice + tax) * adult quantity
     * CHILD TOTAL PRICE  = (basePrice / 2 + tax) * child quantity
     * INFANT TOTAL PRICE = (tax) * infant quantity
     * Total Price = Adult Total Price + Child Total Price + Infant Total Price
     * @param passengers Collection of passengers that will travel.
     * @return Total price of the flight.
     */
    public BigDecimal totalPrice(Collection<Passenger> passengers) {
        //TODO Implementar el precio total siguiendo la formula indicada en la documentación.
        long adultQuantity = cantidadPorTipoPasajero(passengers,PassengerType.ADULT);
        long childQuantity = cantidadPorTipoPasajero(passengers,PassengerType.CHILD);
        long infantQuantity = cantidadPorTipoPasajero(passengers,PassengerType.INFANT);

        BigDecimal adultTotalPrice = (this.basePrice.add(this.taxByPassenger)).multiply(BigDecimal.valueOf(adultQuantity));
        BigDecimal childTotalPrice = (this.basePrice.divide(BigDecimal.valueOf(2)).add(this.taxByPassenger)).multiply(BigDecimal.valueOf(childQuantity));
        BigDecimal infantTotalPrice = (this.taxByPassenger).multiply(BigDecimal.valueOf(infantQuantity));

        return adultTotalPrice.add(childTotalPrice).add(infantTotalPrice);
    }

    private long cantidadPorTipoPasajero (Collection<Passenger> passengers,PassengerType tipoPasajero){
        return passengers.stream().filter(p -> p.getType().equals(tipoPasajero)).count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (!Objects.equals(from, flight.from)) return false;
        if (!Objects.equals(to, flight.to)) return false;
        if (!Objects.equals(departure, flight.departure)) return false;
        if (!Objects.equals(basePrice, flight.basePrice)) return false;
        return Objects.equals(taxByPassenger, flight.taxByPassenger);
    }

    @Override
    public int hashCode() {
        int result = from != null ? from.hashCode() : 0;
        result = 31 * result + (to != null ? to.hashCode() : 0);
        result = 31 * result + (departure != null ? departure.hashCode() : 0);
        result = 31 * result + (basePrice != null ? basePrice.hashCode() : 0);
        result = 31 * result + (taxByPassenger != null ? taxByPassenger.hashCode() : 0);
        return result;
    }

    // Getters

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public LocalDate getDeparture() {
        return departure;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public BigDecimal getTaxByPassenger() {
        return taxByPassenger;
    }
}
