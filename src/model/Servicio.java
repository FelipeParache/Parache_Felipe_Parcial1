package model;

import java.time.LocalDate;
import exceptions.*;

public abstract class Servicio {

    protected String codServicio;
    protected double porcentajeDescuento;
    protected boolean enPromocion;

    public Servicio(String codServicio, double porcentajeDescuento, boolean enPromocion) throws CodServicioIncorrectoException {
        this.codServicio = codServicio;
        this.porcentajeDescuento = porcentajeDescuento;
        this.enPromocion = enPromocion;

        if (codServicio.length() != 6) {
            throw new CodServicioIncorrectoException("El codigo debe tener 6 caracteres");
        }
    }

    public String getCodServicio() {
        return codServicio;
    }

    public void setCodServicio(String codServicio) {
        this.codServicio = codServicio;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public boolean isEnPromocion() {
        return enPromocion;
    }

    public void setEnPromocion(boolean enPromocion) {
        this.enPromocion = enPromocion;
    }

    @Override
    public String toString() {
        return "Servicio:" + "\ncodServicio: " + codServicio + "\nporcentajeDescuento: " + porcentajeDescuento + "\nenPromocion: " + enPromocion;
    }

    public abstract double calcularPrecioFinal(LocalDate dia);
}
