package com.despegar.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Caja<T> implements Iterable<T> {

    private final List<T> elementos = new ArrayList<T>();
    private final int tope;

    public Caja(int tope) {this.tope = tope;}

    public void add(T elemento) {
        if (elementos.size() < tope)
            elementos.add(elemento);
        else
            System.out.println("ERROR - No se puede agregar mas elementos, la caja esta llena.");
    }

    public int size(){
        return elementos.size();
    }


    @Override
    public Iterator<T> iterator() {
        return elementos.iterator();
    }
}
