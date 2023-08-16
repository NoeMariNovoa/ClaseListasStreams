package com.despegar.demo.record.eq;

import java.util.Objects;

public final class Persona {
    private final String nombre;
    private final String apellido;

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona that = (Persona) o;
        return (Objects.equals(nombre, that.nombre)) && Objects.equals(apellido, that.apellido);
    }

    @Override
    public int hashCode() { return Objects.hash(nombre, apellido); }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
}
