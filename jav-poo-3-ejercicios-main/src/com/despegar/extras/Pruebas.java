package com.despegar.extras;

import com.despegar.extras.modelos.Auto;

public class Pruebas {

    public static void main(String[] args) {

        Pruebas pruebas = new Pruebas();
        pruebas.pruebasDiccionarioDeAutosConLista();
        pruebas.pruebasDiccionarioGenerico();
        pruebas.pruebasListaDeAutosConArray();
        pruebas.pruebasGenerica();

    }

    private void pruebasListaDeAutosConArray () {
        ListaDeAutosConArray lista = new ListaDeAutosConArray();
        boolean pasoLosTest = true;
        Auto auto1 = new Auto(4, 5, false, "Negro");
        Auto auto2 = new Auto(4, 3, true, "Verde");
        Auto auto3 = new Auto(6, 5, true, "Blanco");
        Auto auto4 = new Auto(4, 3, false, "Rojo");

        lista.agregarAuto(auto1);
        lista.agregarAuto(auto2);
        lista.agregarAuto(auto3);

        pasoLosTest = pasoLosTest & lista.cantidadDeAutos() == 3;

        pasoLosTest = pasoLosTest & lista.contieneAuto(auto1);
        pasoLosTest = pasoLosTest & lista.contieneAuto(auto2);
        pasoLosTest = pasoLosTest & lista.contieneAuto(auto3);
        pasoLosTest = pasoLosTest & !lista.contieneAuto(auto4);

        pasoLosTest = pasoLosTest & lista.autoEnPosicion(0).equals(auto1);
        pasoLosTest = pasoLosTest & lista.autoEnPosicion(1).equals(auto2);
        pasoLosTest = pasoLosTest & lista.autoEnPosicion(2).equals(auto3);

        lista.removerAuto(auto4);
        pasoLosTest = pasoLosTest & lista.cantidadDeAutos() == 3;

        lista.removerAuto(auto2);
        pasoLosTest = pasoLosTest & lista.contieneAuto(auto1);
        pasoLosTest = pasoLosTest & lista.contieneAuto(auto3);


        lista.removerAutoEnPosicion(5);
        pasoLosTest = pasoLosTest & lista.cantidadDeAutos() == 2;

        lista.removerAutoEnPosicion(1);
        pasoLosTest = pasoLosTest & lista.contieneAuto(auto1);
        pasoLosTest = pasoLosTest & !lista.contieneAuto(auto3);

        mensaje("pruebasListaDeAutosConArray", pasoLosTest);
    }
    private void  pruebasDiccionarioGenerico() {
        DiccionarioGenerico<Auto, Integer> diccionarioGenerico = new DiccionarioGenerico<Auto, Integer>();
        boolean pasoLosTest = true;
        Auto auto1 = new Auto(4, 3, true, "Negro");
        Auto auto2 = new Auto(4, 4, false, "Verde");
        Auto auto3 = new Auto(6, 2, true, "Blanco");
        Auto auto4 = new Auto(4, 5, false, "Rojo");

        diccionarioGenerico.asociarClaveConValor(auto1, 6);
        diccionarioGenerico.asociarClaveConValor(auto2, 7);
        diccionarioGenerico.asociarClaveConValor(auto3, 8);
        diccionarioGenerico.asociarClaveConValor(auto4, 9);

        for (Auto auto : diccionarioGenerico.conjuntoDeClaves()) {
            assert diccionarioGenerico.obtenerValor(auto) != 0;
        }

        pasoLosTest = pasoLosTest & diccionarioGenerico.conjuntoDeClaves().size() == 4;

        pasoLosTest = pasoLosTest &  diccionarioGenerico.obtenerValor(auto1) == 6;
        pasoLosTest = pasoLosTest &  diccionarioGenerico.obtenerValor(auto2) == 7;
        pasoLosTest = pasoLosTest &  diccionarioGenerico.obtenerValor(auto3) == 8;
        pasoLosTest = pasoLosTest &  diccionarioGenerico.obtenerValor(auto4) == 9;

        diccionarioGenerico.asociarClaveConValor(auto1, 2);
        pasoLosTest = pasoLosTest &  diccionarioGenerico.obtenerValor(auto1) == 2;

        mensaje("pruebasDiccionarioGenerico", pasoLosTest);
    }

    private void  pruebasDiccionarioDeAutosConLista(){
        DiccionarioDeAutosConLista diccionario = new DiccionarioDeAutosConLista();
        boolean pasoLosTest = true;
        Auto auto1 = new Auto(4, 5, true, "Negro");
        Auto auto2 = new Auto(4, 3, false, "Verde");
        Auto auto3 = new Auto(6, 5, true, "Blanco");
        Auto auto4 = new Auto(4, 3, false, "Rojo");

        diccionario.asociarClaveConValor(auto1, 2);
        diccionario.asociarClaveConValor(auto2, 3);
        diccionario.asociarClaveConValor(auto3, 4);
        diccionario.asociarClaveConValor(auto4, 5);

        for (Auto auto : diccionario.conjuntoDeClaves()) {
            assert diccionario.obtenerValor(auto) != 0;
        }

        assert diccionario.conjuntoDeClaves().size() == 4;

        assert diccionario.obtenerValor(auto1) == 2;
        assert diccionario.obtenerValor(auto2) == 3;
        assert diccionario.obtenerValor(auto3) == 4;
        assert diccionario.obtenerValor(auto4) == 5;

        diccionario.asociarClaveConValor(auto1, 10);

        pasoLosTest = pasoLosTest & diccionario.obtenerValor(auto1) == 10;


        mensaje("pruebasDiccionarioDeAutosConLista", pasoLosTest);
    }

    private void pruebasGenerica() {
        ListaGenerica<Auto> arrayList = agregarAutosEnLista(true);
        ListaGenerica<Auto> linkedList = agregarAutosEnLista(false);

        obtenerAutos(arrayList, true);
        obtenerAutos(linkedList, false);

        mensaje("pruebasGenerica", true);
    }

    private  ListaGenerica<Auto> agregarAutosEnLista(boolean useArrayList) {
        ListaGenerica<Auto> listaGenerica = new ListaGenerica<Auto>(useArrayList);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            Auto auto = new Auto(4, 4, false, "Negro");
            listaGenerica.agregarAuto(auto);
        }
        long elapsedTime = System.currentTimeMillis() - startTime;
        if (useArrayList) {
            System.out.println("[Insertar] ArrayList tardó en millis: " + elapsedTime);
        } else {
            System.out.println("[Insertar] LinkedList tardó en millis: " + elapsedTime);
        }
        return listaGenerica;
    }

    private void obtenerAutos(ListaGenerica<Auto> listaGenerica, boolean useArrayList) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            Auto auto = listaGenerica.autoEnPosicion(i);
        }
        long elapsedTime = System.currentTimeMillis() - startTime;
        if (useArrayList) {
            System.out.println("[Obtener] ArrayList tardó en millis: " + elapsedTime);
        } else {
            System.out.println("[Obtener] LinkedList tardó en millis: " + elapsedTime);
        }
    }
    private static void mensaje(String nombreDePrueba,boolean pasoLosTest) {
        if (pasoLosTest)
            System.out.println(nombreDePrueba +" => Pasó todo los tests :)");
        else
            System.err.println(nombreDePrueba +" => NO PASO LOS TEST :(");
    }

}
