package com.despegar.extras;

import com.despegar.extras.modelos.Auto;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsTest {

    public static void main(String[] args) {
        List<Auto> autos = stock();

        List<Auto> automaticos = autosAutomaticos(autos);
        assert automaticos.size() == 5;

        List<Auto> manuales = autosManuales(autos);
        assert manuales.size() == 4;

        List<Auto> autosCon3PuertasYDeColorAzul = autosCon3PuertasYDeColorAzul(autos);
        assert autosCon3PuertasYDeColorAzul.size() == 2;

        Integer cantAutosCon5Puertas = cantidadAutosCon5Puertas(autos);
        assert cantAutosCon5Puertas == 4;
        
        Boolean autosCon3Ruedas = hayAutosCon3Ruedas(autos);
        assert autosCon3Ruedas == false;
        
        List<String> coloresAutos = coloresDeAutos(autos);
        assert coloresAutos.size() == 7;
    }

    private static List<Auto> stock() {
        return Arrays.asList(
                new Auto(4, 3, true, "Negro"),
                new Auto(4, 4, false, "Blanco"),
                new Auto(4, 5, true, "Rojo"),
                new Auto(4, 3, true, "Azul"),
                new Auto(4, 3, false, "Azul"),
                new Auto(4, 5, false, "Naranja"),
                new Auto(4, 5, true, "Rojo"),
                new Auto(4, 4, false, "Amarillo"),
                new Auto(4, 5, true, "Rosa")
        );
    }

    private static List<Auto> autosAutomaticos(List<Auto> autos) {
        /*
        TODO: IMPLEMENTAR SIN utilizar streams:
            1.- Devolver OTRA lista de autos incluyendo solamente aquellos con caja automática, respetando
                el mismo orden de aparación en la lista original
        */
        List<Auto> nuevaLista = new ArrayList<Auto>();
        nuevaLista.addAll(autos);
        nuevaLista.removeAll(autosManuales(autos));
        return nuevaLista;
    }

    private static List<Auto> autosManuales(List<Auto> autos) {
        /*
        TODO: IMPLEMENTAR utilizando streams
            1.- Devolver OTRA lista de autos incluyendo solamente aquellos con caja manual, respetando
                el mismo orden de aparación en la lista original
        */
        return autos.stream().filter(a -> a.getCajaAutomatica()==false).collect(Collectors.toList());
    }

    private static List<Auto> autosCon3PuertasYDeColorAzul(List<Auto> autos) {
        /*
        TODO: IMPLEMENTAR utilizando streams
            1.- Devolver OTRA lista de autos incluyendo solamente aquellos con 3 puertas y de color Azul, respetando
                el mismo orden de aparación en la lista original
        */
        return autos.stream().filter(a -> a.getPuertas()==3 && a.getColor().equalsIgnoreCase("Azul")).collect(Collectors.toList());
    }
    
    private static Integer cantidadAutosCon5Puertas(List<Auto> autos) {
        /*
        TODO: IMPLEMENTAR utilizando streams
            1.- Devolver la cantidad de autos que tienen 5 puertas
        */
        return Math.toIntExact(autos.stream().filter(a -> a.getPuertas() == 5).count());
    }
    
    private static Boolean hayAutosCon3Ruedas(List<Auto> autos) {
        /*
        TODO: IMPLEMENTAR utilizando streams
            1.- Devolver un Boolean que indique si hay autos con 3 ruedas
        */

        return autos.stream().anyMatch(a-> a.getRuedas()==3);
    }
    
    private static List<String> coloresDeAutos(List<Auto> autos) {
        /*
        TODO: IMPLEMENTAR utilizando streams
            1.- Devolver la lista de colores de los autos de la lista recibida
        */
        return autos.stream().map(a -> a.getColor()).collect(Collectors.toList());
    }

}
