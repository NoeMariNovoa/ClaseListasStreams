package com.despegar.demo;

import java.util.*;

public class DemoBaseCollections {

    public static void main(String[] args) {
        demoCaja();
        System.out.println("Demo para Lista");
        demoCollection(new ArrayList<>());
        System.out.println("Demo para Set");
        demoCollection(new HashSet<>());
        System.out.println("Demo para Map");
        demoMap();
    }

    private static void demoCaja(){
        System.out.println("**** DEMO CAJA INICIO ****");
        Caja<String> nombres = new Caja<String>(1);
        nombres.add("Despegar");
        System.out.println("La caja de nombres tiene " + nombres.size() + " elementos.");
        nombres.add("Decolar");
        System.out.println("La caja de nombres tiene " + nombres.size() + " elementos.");
        System.out.println("**** DEMO CAJA FINAL ****");

        // Acciones no permitidas:
        // Caja<Integer> numeros = nombres;
        // nombres.add(1);
    }

    private static void demoCollection(Collection<String> collection){
        System.out.println("**** DEMO Collection INICIO ****");
        String despegar = "Despegar.com";
        // Primera Parte
        collection.add(despegar);
        collection.add(despegar);
        System.out.println("1. Se agrego dos veces el elemento: " + despegar);
        System.out.println("1.1 La colección tiene " + collection.size() + " elementos.");
        System.out.println("1.2 ¿Esta vacía? " + collection.isEmpty());
        System.out.println("1.3 ¿Contiene a Despegar.com? " + collection.contains("Despegar.com"));
        printCollectionIterator(collection);
        // Segunda Parte
        collection.remove(despegar);
        System.out.println("2 Se remueve una vez el elemento " + despegar);
        System.out.println("2.1 La colección tiene " + collection.size() + " elementos.");
        System.out.println(collection);
        // Tercera Parte
        if (!collection.isEmpty()){
            collection.remove(despegar);
            System.out.println("3 Se remueve una vez mas el elemento " + despegar);
            System.out.println("3 ¿Esta vacía? " + collection.isEmpty());
            System.out.println(collection);
        }
        System.out.println("**** DEMO Collection Fin ****");
    }

    private static <T> void printCollectionIterator(Collection<T> collection){
        System.out.println("Inicio recorrido colección con Iterador");
        Iterator<T> iterator = collection.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
        System.out.println("Fin recorrido colección con Iterador");
    }


    private static void demoMap(){
        Map<String, String> diccionario = new HashMap<>();
        String peon = "Peon";
        diccionario.put(peon, "Pieza de ajedrez que se mueve en diagonal.");
        System.out.println("Se agrega al mapa un elemento.");
        System.out.println("¿Contiene una clave: " + peon + "? " + diccionario.containsKey(peon));
        System.out.println("El valor es:  " + diccionario.get("Peon"));
        diccionario.put(peon, "Pieza de ajedrez que se mueve hacia adelante.");
        System.out.println("Se agrega al mapa un elemento.");
        System.out.println("¿Contiene una clave: " + peon + "? " + diccionario.containsKey(peon));
        System.out.println("El valor es:  " + diccionario.get(peon));
        System.out.println("El diccionario posee: " + diccionario.size() + " elementos.");
        diccionario.remove(peon);
        System.out.println("¿Contiene una clave: " + peon + "? " + diccionario.containsKey(peon));
        System.out.println("El diccionario posee: " + diccionario.size() + " elementos. ¿Vacío? " + diccionario.isEmpty());
    }
}
