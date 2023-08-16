package com.despegar.extras;

import com.despegar.extras.modelos.Auto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListaGenerica<T> {

    private List<T> lista;

    public ListaGenerica(boolean useArrayList) {
        // inicializo una lista vacía
        if (useArrayList) {
            lista = new ArrayList<>(0);
        } else {
            lista = new LinkedList<>();
        }
    }

    public int cantidadDeAutos() {
        /*
        TODO: IMPLEMENTAR siguientos estos conceptos:
            1.- Devolver el tamaño de la lista sin recorrerla
         */
        return this.lista.size();
    }

    public T autoEnPosicion(int posicion) {
        /*
        TODO: IMPLEMENTAR siguiendo estos conceptos:
            1.- Devolver el auto en la posición indicada como parámetro
         */

        return lista.get(posicion);
    }

    public boolean contieneAuto(T auto) {
        /*
        TODO: IMPLEMENTAR siguiendo estos conceptos:
            1.- Devolver true si el auto pasado como parámetro está incluído en la lista
         */
        return lista.stream().anyMatch(a -> a.equals(auto));
    }

    public void agregarAuto(T auto) {
        /*
        TODO: IMPLEMENTAR siguiendo estos conceptos:
            1.- Insertar el auto al final de la lista
         */
        lista.add(auto);
    }

    public void removerAuto(T auto) {
        /*
        TODO: IMPLEMENTAR siguiendo estos conceptos:
            1.- Remover la primer ocurrencia del auto pasado como parámetro
         */

        if(lista.contains(auto)){
            lista.remove(auto);
        }
    }

    public void removerAutoEnPosicion(int posicion) {
        /*
        TODO: IMPLEMENTAR siguiendo estos conceptos:
            1.- Remover el auto en la posición pasada como parámetro
         */

        lista.remove(lista.get(posicion));
    }

}
