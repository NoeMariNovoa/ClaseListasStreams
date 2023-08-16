package com.despegar.extras;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DiccionarioGenerico<K, V> {

    private Map<K, V> map;

    public DiccionarioGenerico() {
        // inicializo un mapa vacío
        map = new HashMap<K, V>();
    }

    public void asociarClaveConValor(K clave, V valor) {
        /*
        TODO: IMPLEMENTAR siguientos estos conceptos:
            1.- Insertar en el mapa el valor asociándolo a la clave
         */
        map.put(clave,valor);
    }

    public V obtenerValor(K clave) {
        /*
        TODO: IMPLEMENTAR siguientos estos conceptos:
            1.- Obtener del mapa el valor a partir de la clave
         */
        return map.get(clave);
    }

    public Set<K> conjuntoDeClaves() {
        /*
        TODO: IMPLEMENTAR siguientos estos conceptos:
            1.- Devolver el conjunto de claves asociadas al mapa
         */
        return map.keySet();
    }

}
