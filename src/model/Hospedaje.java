package model;

import exceptions.CodServicioIncorrectoException;
import java.time.LocalDate;

public class Hospedaje extends Servicio {

    private String hospedaje;
    private double precioPorNoche;

    public Hospedaje(String codServicio, String hospedaje, double precioPorNoche, double porcentajeDescuento, boolean enPromocion) throws CodServicioIncorrectoException {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.hospedaje = hospedaje;
        this.precioPorNoche = precioPorNoche;
    }

    public String getHospedaje() {
        return hospedaje;
    }

    public void setHospedaje(String hospedaje) {
        this.hospedaje = hospedaje;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    @Override
    public String toString() {
        return super.toString() + "\nHospedaje:" + "\nhospedaje: " + hospedaje + "\nprecioPorNoche: " + precioPorNoche;
    }

    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        double precioFinal = this.precioPorNoche;

        if (this.enPromocion && dia.getDayOfWeek().getValue() >= 1 && dia.getDayOfWeek().getValue() <= 5) {
            precioFinal = this.precioPorNoche - (this.precioPorNoche * this.porcentajeDescuento / 100);
        }

        return precioFinal;
    }

}
