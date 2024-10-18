package model;

import exceptions.CodServicioIncorrectoException;
import java.time.LocalDate;

public class Gastronomia extends Servicio {

    private String gastronomia;
    private double precio;
    private int diaSemDesc;

    public Gastronomia(String codServicio, String gastronomia, double precio, int diaSemDesc, double porcentajeDescuento, boolean enPromocion) throws CodServicioIncorrectoException {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.gastronomia = gastronomia;
        this.precio = precio;
        this.diaSemDesc = diaSemDesc;
    }

    public String getGastronomia() {
        return gastronomia;
    }

    public void setGastronomia(String gastronomia) {
        this.gastronomia = gastronomia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDiaSemDesc() {
        return diaSemDesc;
    }

    public void setDiaSemDesc(int diaSemDesc) {
        this.diaSemDesc = diaSemDesc;
    }

    @Override
    public String toString() {
        return super.toString() + "\nGastronomia:" + "\ngastronomia: " + gastronomia + "\nprecio: " + precio + "\ndiaSemDesc: " + diaSemDesc;
    }

    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        double precioFinal = this.precio;

        if (this.enPromocion && dia.getDayOfWeek().getValue() == this.diaSemDesc) {
            precioFinal = this.precio - (this.precio * this.porcentajeDescuento / 100);
        }

        return precioFinal;
    }

}
