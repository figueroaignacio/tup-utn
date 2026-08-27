package com.utn.gestionpedidos.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "producto")
@Getter
@Setter
@NoArgsConstructor
public class Producto extends Base {

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Double precio;

    @Column(length = 500)
    private String descripcion;

    private int stock;

    private String imagen;

    private Boolean disponible = true;

    /** Lado duenio de la relacion con Categoria: la FK categoria_id esta aca. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    /** Regla de negocio simple: descontar stock al vender. */
    public void descontarStock(int cantidad) {
        this.stock = Math.max(0, this.stock - cantidad);
        this.disponible = this.stock > 0;
    }
}
