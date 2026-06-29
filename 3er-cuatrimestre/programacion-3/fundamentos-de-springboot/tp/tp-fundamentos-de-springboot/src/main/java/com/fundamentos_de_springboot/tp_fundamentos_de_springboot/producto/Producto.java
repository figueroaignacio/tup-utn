package com.fundamentos_de_springboot.tp_fundamentos_de_springboot.producto;

import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.Base;
import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.categoria.Categoria;
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
public class Producto extends Base {
    private String nombre;
    private Double precio;
    private String descripcion;
    private int stock;
    private String imagen;
    private Boolean disponible;

    @ManyToOne
    private Categoria categoria;

    public Producto() {
    }
}