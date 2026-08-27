package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== MÓDULO DE FACTURACIÓN MÉDICA - HOSPITAL CENTRAL ===\n");

        FacturacionServicio facturacion = new FacturacionServicio();
        List<Double> estudios = Arrays.asList(1000.0, 500.0, 1500.0); // Total base: 3000

        // Caso 1: Paciente particular sin beneficios (Total esperado: 3000)
        SolicitudFacturacion solicitud1 = new SolicitudFacturacion(estudios, false, false, 0);
        System.out.println("Caso 1 (Particular): $" + facturacion.calcularTotalFacturacion(solicitud1));

        // Caso 2: Paciente con Prepaga 50% (Total esperado: 1500)
        SolicitudFacturacion solicitud2 = new SolicitudFacturacion(estudios, true, false, 1);
        System.out.println("Caso 2 (Con Prepaga): $" + facturacion.calcularTotalFacturacion(solicitud2));

        // Caso 3: Prepaga + Obra Social + Turnos Frecuentes (>3 turnos) (Total esperado: 1250)
        SolicitudFacturacion solicitud3 = new SolicitudFacturacion(estudios, true, true, 4);
        System.out.println("Caso 3 (Beneficio completo): $" + facturacion.calcularTotalFacturacion(solicitud3));
    }
}