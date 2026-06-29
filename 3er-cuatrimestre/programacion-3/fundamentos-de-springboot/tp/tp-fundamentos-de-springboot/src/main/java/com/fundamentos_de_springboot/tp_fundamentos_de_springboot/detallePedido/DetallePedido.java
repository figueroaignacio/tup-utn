package com.fundamentos_de_springboot.tp_fundamentos_de_springboot.detallePedido;

import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.Base;
import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.producto.Producto;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
public class DetallePedido extends Base {
    private int cantidad;
    private Double subtotal;

    @ManyToOne
    private Producto producto;

    public DetallePedido() {
    }

    public void calcularSubtotal() {
        if (this.producto != null) {
            this.subtotal = this.cantidad * this.producto.getPrecio();
        }
    }
}