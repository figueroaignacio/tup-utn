package org.utn.tp.entities;

import org.utn.tp.enums.Estado;
import org.utn.tp.enums.FormaPago;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido extends Base implements Calculable {
    private LocalDate fecha;
    private Estado estado;
    private Double total = 0.0;
    private FormaPago formaPago;
    private List<DetallePedido> detalles = new ArrayList<>();

    public Pedido(Long id, boolean eliminado, FormaPago formaPago) {
        super(id, eliminado);
        this.fecha = LocalDate.now();
        this.estado = Estado.PENDIENTE;
        this.formaPago = formaPago;
    }

    public void addDetallePedido(int cantidad, Producto producto) {
        this.detalles.add(new DetallePedido(cantidad, producto));
    }

    // 1) desarrolle un método en clase Pedido que se encargue de calcular el total (Usando Streams)
    @Override
    public void calcularTotal() {
        this.total = detalles.stream()
                .mapToDouble(DetallePedido::getSubtotal)
                .sum();
    }

    public Double getTotal() {
        return total;
    }

    public List<DetallePedido> getDetalles() {
        return detalles;
    }
}