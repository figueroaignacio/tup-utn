package org.example;

import org.example.SolicitudFacturacion;

import java.util.List;

public class FacturacionServicio {

    private static final double COBERTURA_PREPAGA_PORCENTAJE = 0.50;
    private static final double FACTOR_DESCUENTO_OBRA_SOCIAL = 0.90;
    private static final int UMBRAL_TURNOS_FRECUENTES = 3;
    private static final double BONIFICACION_TURNOS_FRECUENTES = 100.0;
    private static final double MONTO_MINIMO = 0.0;

    public double calcularTotalFacturacion(SolicitudFacturacion solicitud) {
        if (solicitud == null) {
            throw new IllegalArgumentException("La solicitud de facturación no puede ser nula.");
        }

        double subtotal = calcularSubtotalEstudios(solicitud.getCostosEstudios(), solicitud.poseePrepaga());
        double totalConObraSocial = aplicarDescuentoObraSocial(subtotal, solicitud.poseeObraSocial());
        double totalFinal = aplicarDescuentoTurnosFrecuentes(totalConObraSocial, solicitud.getCantidadTurnosPrevios());

        return Math.max(totalFinal, MONTO_MINIMO);
    }

    private double calcularSubtotalEstudios(List<Double> costosEstudios, boolean poseePrepaga) {
        double subtotal = 0.0;
        for (Double costo : costosEstudios) {
            if (costo == null || costo < 0) {
                continue;
            }
            subtotal += poseePrepaga ? (costo * COBERTURA_PREPAGA_PORCENTAJE) : costo;
        }
        return subtotal;
    }

    private double aplicarDescuentoObraSocial(double monto, boolean poseeObraSocial) {
        return poseeObraSocial ? (monto * FACTOR_DESCUENTO_OBRA_SOCIAL) : monto;
    }

    private double aplicarDescuentoTurnosFrecuentes(double monto, int cantidadTurnos) {
        if (cantidadTurnos > UMBRAL_TURNOS_FRECUENTES) {
            return monto - BONIFICACION_TURNOS_FRECUENTES;
        }
        return monto;
    }
}