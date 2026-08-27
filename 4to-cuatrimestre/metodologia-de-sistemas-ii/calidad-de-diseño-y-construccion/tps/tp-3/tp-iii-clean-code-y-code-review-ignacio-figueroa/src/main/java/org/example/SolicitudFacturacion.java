package org.example;

import java.util.Collections;
import java.util.List;

public class SolicitudFacturacion {

    private final List<Double> costosEstudios;
    private final boolean poseePrepaga;
    private final boolean poseeObraSocial;
    private final int cantidadTurnosPrevios;

    public SolicitudFacturacion(List<Double> costosEstudios,
                                boolean poseePrepaga,
                                boolean poseeObraSocial,
                                int cantidadTurnosPrevios) {
        this.costosEstudios = costosEstudios != null ? costosEstudios : Collections.emptyList();
        this.poseePrepaga = poseePrepaga;
        this.poseeObraSocial = poseeObraSocial;
        this.cantidadTurnosPrevios = cantidadTurnosPrevios;
    }

    public List<Double> getCostosEstudios() {
        return costosEstudios;
    }

    public boolean poseePrepaga() {
        return poseePrepaga;
    }

    public boolean poseeObraSocial() {
        return poseeObraSocial;
    }

    public int getCantidadTurnosPrevios() {
        return cantidadTurnosPrevios;
    }
}
