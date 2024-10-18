package test;

import exceptions.*;
import java.time.LocalDate;
import model.*;

public class Main {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();

        System.out.println("Pruebas de Creacion de Objetos");
        System.out.println("1-1");
        try {
            Servicio gastronomia = new Gastronomia("4892", "Hamburguesa criolla", 180.0, 4, 15.0, true);
            System.out.println(gastronomia.toString());
        } catch (CodServicioIncorrectoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n1-2");
        try {
            Servicio gastronomia = new Gastronomia("489235", "Hamburguesa criolla", 180.0, 4, 15.0, true);
            System.out.println(gastronomia.toString());
        } catch (CodServicioIncorrectoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n1-3");
        try {
            Servicio hospedaje = new Hospedaje("2872", "Cabaña 3 personas", 1500.0, 10.0, true);
            System.out.println(hospedaje.toString());
        } catch (CodServicioIncorrectoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n1-4");
        try {
            Servicio hospedaje = new Hospedaje("287282", "Cabaña 3 personas", 1500.0, 10.0, true);
            System.out.println(hospedaje.toString());
        } catch (CodServicioIncorrectoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nCalculo de Precios Finales");
        System.out.println("2-1");
        try {
            Servicio gastronomia = new Gastronomia("489235", "Hamburguesa criolla", 180.0, 4, 15.0, true);
            LocalDate dia = LocalDate.of(2020, 10, 28);
            double precioFinal = gastronomia.calcularPrecioFinal(dia);
            System.out.println("Precio final del dia " + dia + ": " + precioFinal);
        } catch (CodServicioIncorrectoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n2-2");
        try {
            Servicio hospedaje = new Hospedaje("287282", "Cabaña 3 personas", 1500.0, 10.0, true);
            LocalDate dia = LocalDate.of(2020, 10, 27);
            double precioFinal = hospedaje.calcularPrecioFinal(dia);
            System.out.println("Precio final del dia " + dia + ": " + precioFinal);
        } catch (CodServicioIncorrectoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nAgregar Servicios");
        System.out.println("3");
        try {
            sistema.agregarGastronomia("858927", 15.0, true, "Milanesa con pure", 350.0, 3);
            sistema.agregarHospedaje("489259", 10.0, true, "Habitacion triple", 2200.0);
            sistema.agregarGastronomia("182835", 20.0, false, "Gaseosa", 120.0, 3);
            sistema.agregarHospedaje("758972", 15.0, false, "Habitacion simple", 1000.0);

            System.out.println(sistema.getLstServicio());
        } catch (CodServicioIncorrectoException | ServicioYaExistenteException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nConsultas de Servicios");
        System.out.println("4-1");
        for (Servicio servicio : sistema.traerServicio(true)) {
            System.out.println(servicio.toString());
        }

        System.out.println("\n4-2");
        LocalDate dia = LocalDate.of(2020, 10, 28);
        for (Servicio servicio : sistema.traerServicio(true, dia)) {
            System.out.println(servicio.toString());
        }
    }

}
