package com.despegar.extras.modelos;

import com.despegar.extras.enums.EstadoReserva;
import com.despegar.extras.enums.TipoDescuento;

import java.util.List;
import java.util.Set;

public class Reserva {

    private final String id;
    private final String fecha;
    private final String paisOrigen;
    private final String idioma;
    private final String canal;
    private final EstadoReserva estadoReserva;
    private final List<Producto> productos;
    private final Set<Descuento> descuentos;
    private final List<Pasajero> pasajeros;

    public Reserva(String id, String fecha, String paisOrigen, String idioma, String canal, EstadoReserva estadoReserva, List<Producto> productos, Set<Descuento> descuentos, List<Pasajero> pasajeros) {
        this.id = id;
        this.fecha = fecha;
        this.paisOrigen = paisOrigen;
        this.idioma = idioma;
        this.canal = canal;
        this.estadoReserva = estadoReserva;
        this.productos = productos;
        this.descuentos = descuentos;
        this.pasajeros = pasajeros;
    }

    public String getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public String getIdioma() {
        return idioma;
    }

    public String getCanal() {
        return canal;
    }

    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public Set<Descuento> getDescuentos() {
        return descuentos;
    }

    public List<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public boolean comprobarDescuentoBase() {
        // TODO: Por una promoción tenemos que comprobar que la reserva tiene al menos un Tipo de descuento cupón del 5%
        //  Tip: el método devuelve erroneamente falso, determinar la causa y corregirlo.

        Set<Descuento> setDescuentos = this.getDescuentos();
        Descuento descuento = new Descuento(TipoDescuento.CUPON, 5);
        return setDescuentos.contains(descuento);

    }

    public boolean esPaquete () {
        // TODO: Determinar si la reserva es un paquete (al menos 2 tipos de productos distintos)

        throw new UnsupportedOperationException("Borrar esta linea al implementar el método");
    }

    public boolean tieneDescuentoCupon () {
        // TODO: Determinar si la reserva presenta algún descuento por cupón

        throw new UnsupportedOperationException("Borrar esta linea al implementar el método");
    }

    public int cantidadPasajerosAdultos (){
        // TODO: Obtener cantidad de pasajeros adultos (mayor o igual a 18)

        throw new UnsupportedOperationException("Borrar esta linea al implementar el método");
    }

    public int cantidadPasajerosMenores (){
        // TODO: Determinar cantidad de pasajeros menores de 18

        throw new UnsupportedOperationException("Borrar esta linea al implementar el método");
    }

    public double costoTotalPorAdulto () {
        // TODO: Determinar el costo total por adulto sin aplicar descuentos

        throw new UnsupportedOperationException("Borrar esta linea al implementar el método");
    }

    public double costoTotalPorMenor () {
        // TODO: Determinar el costo total por menor sin aplicar descuentos

        throw new UnsupportedOperationException("Borrar esta linea al implementar el método");
    }

    public double obtenerPorcentajeDescuento () {
        // TODO: Determinar el porcentaje total de descuento. Suma de todos los descuentos de la reserva.

        throw new UnsupportedOperationException("Borrar esta linea al implementar el método");
    }

    public double costoTotal () {
        // TODO: Determinar costo total de la reserva, teniendo en cuenta que:
        //      Si la reserva no está confirmada, se devuelve 0
        //      Si el país de origen es Argentina, se cobra un impuesto adicional del 3%
        //      El costo total es la suma de costos por adulto y menores, más impuestos (si corresponde), menos el total de descuentos.

        throw new UnsupportedOperationException("Borrar esta linea al implementar el método");
    }

}
