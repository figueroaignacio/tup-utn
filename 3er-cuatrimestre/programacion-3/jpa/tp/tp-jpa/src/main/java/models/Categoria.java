package models;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Categoria extends Base {
    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "categoria")
    @Builder.Default
    private List<Producto> productos = new ArrayList<>();
}