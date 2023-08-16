package com.despegar.extras;

import com.despegar.extras.modelos.Auto;

import java.util.*;

public class DiccionarioDeAutosConLista {

    private static int BUCKETS = 100;

    private Set<Auto> listaClaves;
    private List<Integer> listaValores;

    public DiccionarioDeAutosConLista() {
        // inicializo una lista vacía de claves y otra de tamaño BUCKETS con todos ceros para los valores
        listaClaves = new HashSet<Auto>();
        listaValores = new ArrayList<Integer>(Collections.nCopies(BUCKETS, 0));
    }

    private int calcularPosicionDeAuto(Auto auto) {
        /*
        TODO: IMPLEMENTAR siguientos estos conceptos:
            1.- Calcular el hashcode del auto
            2.- Devolver los 2 últimos dígitos del hashcode. Ej: si el hashcode es 1023, devolver 23
                TIP: el operador % devuelve el resto entre 2 números. Ej: 23 % 10 devuelve 3
         */
        int hashCode = Objects.hashCode(auto);
        return hashCode % 100;
    }

    public void asociarClaveConValor(Auto auto, Integer ocurrencias) {
        /*
        TODO: IMPLEMENTAR siguientos estos conceptos:
            1.- Calcular la posición del auto en base al hashcode
            2.- Insertar el número de ocurrencias en esa posición de la lista
            3.- Agregar el auto a la lista de claves
         */

        int posAuto = calcularPosicionDeAuto(auto);
        listaValores.set(posAuto,ocurrencias);
        listaClaves.add(auto);
    }

    public Integer obtenerValor(Auto auto) {
        /*
        TODO: IMPLEMENTAR siguientos estos conceptos:
            1.- Calcular la posición del auto en base al hashcode
            2.- Obtener el número de ocurrencias en esa posición de la lista
         */
        int posAuto = calcularPosicionDeAuto(auto);
        return listaValores.get(posAuto);
    }

    public Set<Auto> conjuntoDeClaves() {
        /*
        TODO: IMPLEMENTAR siguientos estos conceptos:
            1.- Devolver el conjunto de claves asociadas al mapa   ?????
         */
        return listaClaves;
    }

}
