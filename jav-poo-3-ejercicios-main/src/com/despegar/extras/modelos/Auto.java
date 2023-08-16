package com.despegar.extras.modelos;

import java.util.Objects;

public class Auto {

    private Integer ruedas;
    private Integer puertas;
    private Boolean cajaAutomatica;
    private String color;

    public Auto(Integer ruedas, Integer puertas, Boolean cajaAutomatica, String color) {
        this.ruedas = ruedas;
        this.puertas = puertas;
        this.cajaAutomatica = cajaAutomatica;
        this.color = color;
    }

    @Override
    public boolean equals(Object input) {
        /*
        TODO: IMPLEMENTAR siguiendo estos conceptos (en orden):
            1.- Si el auto y el input referencian al mismo objeto, entonces son iguales
            2.- Si el input es null, entonces NO son iguales
            3.- Si las clases de ambos no coinciden, entonces NO son iguales
            4.- Dado que las clases coinciden, ambos son de la misma clase. Por lo tanto, podemos usar polimorfismo,
                convertir el input a Auto y validar que cada una de sus propiedades sean iguales. Si no lo son,
                entonces los objetos NO son iguales
         */

        if(this == input){
            return true;
        }
        if(input == null || getClass()!= input.getClass()){
            return false;
        }

        Auto unAuto = (Auto) input;
        return Objects.equals(ruedas,unAuto.ruedas) && Objects.equals(puertas,unAuto.puertas) && Objects.equals(cajaAutomatica,unAuto.cajaAutomatica) && Objects.equals(color,unAuto.color);

    }

    @Override
    public int hashCode() {
        /*
        TODO: IMPLEMENTAR siguiendo estos conceptos (en orden):
            1.- Inicializar el hash en 0
            2.- Sumarle la cantidad de ruedas del auto
            3.- Sumarle la cantidad de puertas
            4.- Sumarle 1 si tiene caja automática
            5.- Sumarle el hashCode del color
            6.- Devolver el hash
         */
        int hash = 0;
        hash += this.ruedas;
        hash += this.puertas;
        if(this.cajaAutomatica){
            hash += 1;
        };
        hash += Objects.hashCode(color);

        return hash;
    }

    public Boolean getCajaAutomatica() {
        return cajaAutomatica;
    }

    public void setCajaAutomatica(Boolean cajaAutomatica) {
        this.cajaAutomatica = cajaAutomatica;
    }

    public Integer getPuertas() {
        return puertas;
    }

    public void setPuertas(Integer puertas) {
        this.puertas = puertas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getRuedas() {
        return ruedas;
    }

    public void setRuedas(Integer ruedas) {
        this.ruedas = ruedas;
    }
}
