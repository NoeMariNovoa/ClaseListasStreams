package com.despegar.exercise.flight;

import com.despegar.exercise.common.Passenger;
import com.despegar.exercise.common.PassengerType;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class FlightProvider {

    /**
     * Map Available Flights:
     * Key:     Flight available to be booked.
     * Value:   Amount of seats remaining in the flight.
     */
    private final Map<Flight, Integer> availableFlights = new HashMap<>();

    /**
     * TODO (A)
     * Make a search in the available flights.
     * ADULTs and CHILDREN occupy one seat per each
     * INFANTS do not occupy a seat. They sit on the lap of an ADULT.
     *
     * @param from       Origin.
     * @param to         Destination.
     * @param passengers Passengers to travel.
     * @return Collection of Flights available.
     */
    public Collection<Flight> search(String from, String to, LocalDate departure, Collection<Passenger> passengers) {
        Set<Flight> listaVuelos = availableFlights.keySet();
        long cantPasajerosSinInfantes = cantidadPasajerosSinInfantes(passengers);
        Set<Flight> listaVuelosFiltrados = listaVuelosFiltrados (from,to,departure,listaVuelos,cantPasajerosSinInfantes);

        // TODO Implementar una búsqueda que retorne los vuelos disponibles que cumpla con los parámetros recibidos
        return listaVuelosFiltrados;
    }

    private long cantidadPasajerosSinInfantes (Collection<Passenger> passengers){
        return passengers.stream().filter(p -> !p.getType().equals(PassengerType.INFANT)).count();
    }

    private Set<Flight> listaVuelosFiltrados (String from, String to, LocalDate departure,Set<Flight> listaVuelos, long cantPasajerosSinInfantes){
        return listaVuelos.stream().filter(v -> (v.getFrom().equals(from) && v.getTo().equals(to) && v.getDeparture().equals(departure)))
                .filter(v -> this.availableFlights.get(v)>= cantPasajerosSinInfantes).collect(Collectors.toSet());
    }

    /**
     * TODO (B)
     * Make a reservation of the flight received as parameter.
     * Check passenger types behaviour describe in search documentation to check the amount of seats required.
     * In case that an available flight remaining seats is 0, the flight should be removed from the map.
     *
     * @param flight     Flight to be booked.
     * @param passengers Passengers that will travel.
     */
    public void book(Flight flight, Collection<Passenger> passengers) {
        // TODO Implementar la reserva del vuelo recibido.
        long cantPasajerosSinInfantes = cantidadPasajerosSinInfantes(passengers);

        long diferenciaAsientos = availableFlights.get(flight) - cantPasajerosSinInfantes;

        if (diferenciaAsientos==0){
            availableFlights.remove(flight);
        }
        else if (diferenciaAsientos>0){
            Integer asientosDisponiblesActualizados = Math.toIntExact(availableFlights.get(flight) + diferenciaAsientos);
            availableFlights.put(flight,asientosDisponiblesActualizados);
        }
        else{
            System.out.println("No hay la cantidad de asientos disponibles deseada.");
        }
    }

    /**
     * TODO (D)
     * See documentation of search method.
     *
     * @return List of Flights available, order by price.
     */
    public List<Flight> searchOrderByPrice(String from, String to, LocalDate departure, Collection<Passenger> passengers) {
        // TODO Implementar una búsqueda que retorne los vuelos disponibles ordenados por precio.
        Collection<Flight> buscarVuelosDisponibles = search(from, to, departure, passengers);
        //List<Flight> vuelosDisponiblesOrdenados = buscarVuelosDisponibles.stream().sorted(Comparator.comparing(Flight::getBasePrice)).collect(Collectors.toList());
        List<Flight> vuelosDisponiblesOrdenados = buscarVuelosDisponibles.stream().sorted(Comparator.comparing(f -> f.totalPrice(passengers))).collect(Collectors.toList());

        return vuelosDisponiblesOrdenados;
    }


    // Other implemented methods
    public void addFlight(Flight flight, Integer availableSeats) {
        availableFlights.put(flight, availableSeats);
    }

    public Integer availableSeats(Flight flight) {
        if (!availableFlights.containsKey(flight))
            return 0;
        return availableFlights.get(flight);
    }

    public Integer amountOfFlightsAvailable() {
        return availableFlights.size();
    }

    public void clear() {
        availableFlights.clear();
    }
}
