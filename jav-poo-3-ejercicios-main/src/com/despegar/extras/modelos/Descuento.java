package com.despegar.extras.modelos;

import com.despegar.extras.enums.TipoDescuento;

public class Descuento {

    private TipoDescuento tipo;
    private int porcentaje;

    public Descuento(TipoDescuento tipo, int porcentaje) {
        this.tipo = tipo;
        this.porcentaje = porcentaje;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(final int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public TipoDescuento getTipo() {
        return tipo;
    }

    public void setTipo(final TipoDescuento tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        return (int) (Math.random() * 1000);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (!(obj instanceof Descuento)) return false;
        if (this.getClass() != obj.getClass()) return false;
        Descuento descuento = (Descuento) obj;
        return this.porcentaje == descuento.getPorcentaje() && this.tipo.equals(descuento.tipo);
    }

}
