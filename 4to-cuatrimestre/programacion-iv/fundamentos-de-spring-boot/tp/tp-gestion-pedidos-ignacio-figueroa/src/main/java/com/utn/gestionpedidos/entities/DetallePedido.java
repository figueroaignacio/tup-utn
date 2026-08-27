package com.utn.gestionpedidos.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "detalle_pedido")
@Getter
@Setter
@NoArgsConstructor
public class DetallePedido extends Base {

    private int cantidad;

    private Double subtotal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "producto_id")
    private Producto producto;

    public DetallePedido(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
        calcularSubtotal();
    }

    /** subtotal = precio unitario * cantidad */
    public void calcularSubtotal() {
        if (producto != null && producto.getPrecio() != null) {
            this.subtotal = producto.getPrecio() * cantidad;
        } else {
            this.subtotal = 0.0;
        }
    }
}
