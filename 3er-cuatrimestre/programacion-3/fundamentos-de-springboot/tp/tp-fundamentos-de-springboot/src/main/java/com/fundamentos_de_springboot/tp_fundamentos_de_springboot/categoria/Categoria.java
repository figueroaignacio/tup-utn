package com.fundamentos_de_springboot.tp_fundamentos_de_springboot.categoria;

import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.Base;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Categoria extends Base {
    private String nombre;
    private String descripcion;

    public Categoria() {
    }
}