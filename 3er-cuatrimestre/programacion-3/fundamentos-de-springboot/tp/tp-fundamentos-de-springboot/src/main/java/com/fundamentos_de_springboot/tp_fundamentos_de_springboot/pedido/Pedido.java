package com.fundamentos_de_springboot.tp_fundamentos_de_springboot.pedido;

import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.Base;
import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.Calculable;
import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.detallePedido.DetallePedido;
import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.enums.Estado;
import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.enums.FormaPago;
import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Pedido extends Base implements Calculable {
    private LocalDate fecha;
    private Estado estado;
    private Double total = 0.0;
    private FormaPago formaPago;

    @ManyToOne
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pedido_id")
    private List<DetallePedido> detalles = new ArrayList<>();

    public Pedido() {
    }

    @Override
    public void calcularTotal() {
        this.total = detalles.stream()
                .mapToDouble(d -> {
                    d.calcularSubtotal();
                    return d.getSubtotal();
                }).sum();
    }
}