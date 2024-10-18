package model;

import java.util.List;
import java.util.ArrayList;
import exceptions.*;
import java.time.LocalDate;

public class Sistema {

    private List<Servicio> lstServicio;

    public Sistema() {
        this.lstServicio = new ArrayList<>();
    }

    public List<Servicio> getLstServicio() {
        return lstServicio;
    }

    public void setLstServicio(List<Servicio> lstServicio) {
        this.lstServicio = lstServicio;
    }

    public Servicio traerServicio(String codServicio) throws CodServicioIncorrectoException {
        Servicio retorno = null;
        for (Servicio servicio : this.lstServicio) {
            if (servicio.getCodServicio().equals(codServicio)) {
                retorno = servicio;
            }
        }
        return retorno;
    }

    public List<Servicio> traerServicio(boolean enPromocion) {
        List<Servicio> lstRetorno = new ArrayList<>();

        for (Servicio servicio : this.lstServicio) {
            if (servicio.isEnPromocion() && enPromocion) {
                lstRetorno.add(servicio);
            } else {
                lstRetorno.add(servicio);
            }
        }

        return lstRetorno;
    }

    public List<Servicio> traerServicio(boolean enPromocion, LocalDate dia) {
        List<Servicio> lstRetorno = new ArrayList<>();

        for (Servicio servicio : this.lstServicio) {
            if (servicio.isEnPromocion() == enPromocion) {
                double precioFinal = servicio.calcularPrecioFinal(dia);

                if (servicio instanceof Hospedaje hospedaje) {
                    if (precioFinal != hospedaje.getPrecioPorNoche()) {
                        lstRetorno.add(servicio);
                    }
                } else if (servicio instanceof Gastronomia gastronomia) {
                    if (precioFinal != gastronomia.getPrecio()) {
                        lstRetorno.add(servicio);
                    }
                }
            }
        }

        return lstRetorno;
    }

    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) throws CodServicioIncorrectoException, ServicioYaExistenteException {
        if (this.traerServicio(codServicio) != null) {
            throw new ServicioYaExistenteException("El servico ya existe dentro de la lista");
        }

        Gastronomia nuevoServicio = new Gastronomia(codServicio, gastronomia, precio, diaSemDesc, porcentajeDescuento, enPromocion);
        return this.lstServicio.add(nuevoServicio);
    }

    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) throws CodServicioIncorrectoException, ServicioYaExistenteException {
        if (this.traerServicio(codServicio) != null) {
            throw new ServicioYaExistenteException("El servico ya existe dentro de la lista");
        }

        Hospedaje nuevoServicio = new Hospedaje(codServicio, hospedaje, precioPorNoche, porcentajeDescuento, enPromocion);
        return this.lstServicio.add(nuevoServicio);
    }
}
