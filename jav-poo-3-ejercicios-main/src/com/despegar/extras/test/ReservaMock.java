package com.despegar.extras.test;

import com.despegar.extras.enums.EstadoReserva;
import com.despegar.extras.enums.TipoDescuento;
import com.despegar.extras.enums.TipoProducto;
import com.despegar.extras.modelos.Descuento;
import com.despegar.extras.modelos.Pasajero;
import com.despegar.extras.modelos.Producto;
import com.despegar.extras.modelos.Reserva;

import java.util.List;
import java.util.Set;

public class ReservaMock {
    public static Reserva crearReserva() {
        Descuento descuento1 = new Descuento(TipoDescuento.CUPON, 5);
        Descuento descuento2 = new Descuento(TipoDescuento.CUPON, 7);
        Descuento descuento3 = new Descuento(TipoDescuento.PUNTOS,13);
        // PASAJEROS
        Pasajero pasajero1 = new Pasajero("Maria Cervantes", "mariacervantes@gmail.com", "094583728", "25");
        Pasajero pasajero2 = new Pasajero("Manuel Rivas", "manuelrivas@gmail.com", "095382937", "30");
        Pasajero pasajero3 = new Pasajero("Carolina Rivas", "carolinaperez@gmail.com", "094382738", "5");
        Pasajero pasajero4 = new Pasajero("Franco Rivas", "francorivas@gmail.com", "099382758", "10");

        // PRODUCTOS
        Producto producto1 = new Producto("prod01", TipoProducto.VUELO, "vuelo a Qatar", 5000, 3000);
        Producto producto2 = new Producto("prod02", TipoProducto.HOTEL, "hotel Time Rako en Doha", 300, 220);
        Producto producto3 = new Producto("prod03", TipoProducto.TRASLADO, "traslado de aeropuerto de Qatar a hotel Time Rako en Doha", 20, 10);


        // RESERVAS

        return new Reserva("res01",
                "01-12-2023",
                "AR",
                "ES",
                "iphone",
                EstadoReserva.CONFIRMADA,
                List.of(producto1, producto2, producto3),
                Set.of(descuento1, descuento2, descuento3),
                List.of(pasajero1, pasajero2, pasajero3, pasajero4));
    }

}
