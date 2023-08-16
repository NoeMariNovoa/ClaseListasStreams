package com.despegar.extras;

import com.despegar.extras.modelos.Auto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListaDeAutosConArray {

    private Auto[] autos;

    public ListaDeAutosConArray() {
        // creo un array con 0 elementos (array vacío)
        autos = new Auto[0];
    }

    public int cantidadDeAutos() {
        /*
        TODO: IMPLEMENTAR siguientos estos conceptos:
            1.- Devolver el tamaño del array sin recorrerlo
            TIP: El método length de un array devuelve un entero con su tamaño
         */

        return this.autos.length;
        //throw new UnsupportedOperationException("Borrar esta linea al implementar el método");
    }

    public Auto autoEnPosicion(int posicion) {
        /*
        TODO: IMPLEMENTAR siguiendo estos conceptos:
            1.- Devolver el auto en la posición indicada como parámetro
            TIP: array[i] les permite obtener el i-ésimo elemento de un array\
            TIP2: el primer elemento empieza en la posición 0. Si la posición es inválida, devolver null
         */
        if(posicion<0 || posicion>(cantidadDeAutos()-1)){
            return null;
        }else{
            return this.autos[posicion];
        }
    }

    public boolean contieneAuto(Auto auto) {
        /*
        TODO: IMPLEMENTAR siguiendo estos conceptos:
            1.- Devolver true si el auto pasado como parámetro está incluído en el array
         */

        int contadorContieneAuto = 0;
        for(int i=0;i<this.autos.length;i++){
            if(autoEnPosicion(i).equals(auto)){
                contadorContieneAuto++;
            };
        }

        return contadorContieneAuto>0;

                /*
        OTRA FORMA
        List<Auto> autosLista = Arrays.stream(this.autos).toList();
        List<Auto> autosListaFiltrada = autosLista.stream().filter(a-> a.equals(auto)).collect(Collectors.toList());

        return autosListaFiltrada.size()>0;
         */
    }

    public void agregarAuto(Auto auto) {
        /*
        TODO: IMPLEMENTAR siguiendo estos conceptos:
            1.- Los arrays tienen tamaño fijo, así que es necesario crear uno nuevo con el tamaño actual + 1
            2.- Copiar los autos del array original en el nuevo array manteniendo el mismo orden
            3.- Agregar el auto al final del nuevo array
         */

        Auto[] autosNuevo = new Auto[this.autos.length + 1];

        for(int i=0;i<this.autos.length;i++){
            autosNuevo[i] = autoEnPosicion(i);
        }

        autosNuevo[this.autos.length] = auto;

        this.autos = autosNuevo;
    }

    public void removerAuto(Auto auto) {
        /*
        TODO: IMPLEMENTAR siguiendo estos conceptos:
            1.- Los arrays tienen tamaño fijo, así que es necesario crear uno nuevo con el tamaño actual - 1
            2.- Copiar los autos del array original en el nuevo array manteniendo el mismo orden,
                excluyendo la primer ocurrencia del auto pasado como parametro
            TIP: si el auto no está contenido en el array, no hacer nada
         */

        if(Arrays.asList(this.autos).stream().anyMatch(a -> a.equals(auto))){
            Auto[] autosNuevo = new Auto[this.autos.length - 1];
            boolean primerOcurrenciaAutoEliminada = false;
            int contadorAutosNuevos =0;
            for(int i=0;i<this.autos.length;i++){
                if(!autoEnPosicion(i).equals(auto)){
                    autosNuevo[contadorAutosNuevos] = autoEnPosicion(i);
                    contadorAutosNuevos++;
                }
                else{
                    if(primerOcurrenciaAutoEliminada){
                        autosNuevo[contadorAutosNuevos] = autoEnPosicion(i);
                        contadorAutosNuevos++;
                    }
                    primerOcurrenciaAutoEliminada = true;
                }
            }

            this.autos = autosNuevo;
        }
    }

    public void removerAutoEnPosicion(int posicion) {
        /*
        TODO: IMPLEMENTAR siguiendo estos conceptos:
            1.- Los arrays tienen tamaño fijo, así que es necesario crear uno nuevo con el tamaño actual - 1
            2.- Copiar los autos del array original en el nuevo array manteniendo el mismo orden,
                excluyendo el auto que estaba originalmente en la posición pasada como parámetro
            TIP: el primer elemento empieza en la posición 0. Si la posición es inválida, no hacer nada
         */

        if(posicion>=0 && posicion<=(cantidadDeAutos()-1)){
            Auto[] autosNuevo = new Auto[this.autos.length - 1];
            int contadorAutosNuevos =0;
            for(int i=0;i<this.autos.length;i++){
                if(i != posicion){
                    autosNuevo[contadorAutosNuevos] = autoEnPosicion(i);
                    contadorAutosNuevos++;
                }
            }

            this.autos = autosNuevo;
        }

    }

}
