package com.despegar.extras.test;

import com.despegar.extras.modelos.Reserva;

public class ReservaTest {

    public static void main(String[] args) {

        Reserva reserva = ReservaMock.crearReserva();

        TestUtils.check(reserva.comprobarDescuentoBase());

        TestUtils.check(reserva.esPaquete());

        TestUtils.check(reserva.tieneDescuentoCupon());

        TestUtils.checkEquals(reserva.cantidadPasajerosAdultos(), 2);

        TestUtils.checkEquals(reserva.cantidadPasajerosMenores(), 2);

        TestUtils.checkEquals(reserva.costoTotalPorAdulto(), 5320.0);

        TestUtils.checkEquals(reserva.costoTotalPorMenor(), 3230.0);

        TestUtils.checkEquals(reserva.obtenerPorcentajeDescuento(), 25.0);

        TestUtils.checkEquals(reserva.costoTotal(), 13209.75);

    }

}
