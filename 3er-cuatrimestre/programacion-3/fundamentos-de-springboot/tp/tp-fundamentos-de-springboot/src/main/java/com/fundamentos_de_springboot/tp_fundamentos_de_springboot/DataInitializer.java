package com.fundamentos_de_springboot.tp_fundamentos_de_springboot;

import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.categoria.CategoriaService;
import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.categoria.dto.CategoriaCreate;
import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.detallePedido.dto.DetallePedidoCreate;
import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.enums.FormaPago;
import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.enums.Rol;
import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.pedido.PedidoService;
import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.pedido.dto.PedidoCreate;
import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.producto.ProductoService;
import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.producto.dto.ProductoCreate;
import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.usuario.UsuarioService;
import com.fundamentos_de_springboot.tp_fundamentos_de_springboot.usuario.dto.UsuarioCreate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UsuarioService usuarioService;
    private final CategoriaService categoriaService;
    private final ProductoService productoService;
    private final PedidoService pedidoService;

    // Inyección por constructor estricta
    public DataInitializer(UsuarioService usuarioService, CategoriaService categoriaService,
                           ProductoService productoService, PedidoService pedidoService) {
        this.usuarioService = usuarioService;
        this.categoriaService = categoriaService;
        this.productoService = productoService;
        this.pedidoService = pedidoService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("====== INICIANDO PERSISTENCIA DESDE DTOs ======");

        // 1) Crear 3 Categorías
        for (int i = 1; i <= 3; i++) {
            CategoriaCreate cat = new CategoriaCreate();
            cat.setNombre("Categoria " + i);
            cat.setDescripcion("Descripcion de Cat " + i);
            categoriaService.crear(cat);
        }

        // 2) Crear 2 Usuarios
        UsuarioCreate u1 = new UsuarioCreate();
        u1.setNombre("Edgar");
        u1.setApellido("Figueroa");
        u1.setMail("edgar@mail.com");
        u1.setContrasena("root");
        u1.setRol(Rol.ADMIN);
        usuarioService.crear(u1);

        UsuarioCreate u2 = new UsuarioCreate();
        u2.setNombre("Ana");
        u2.setApellido("Gomez");
        u2.setMail("ana@mail.com");
        u2.setContrasena("user123");
        u2.setRol(Rol.USUARIO);
        usuarioService.crear(u2);

        // 3) Crear 10 Productos
        for (int i = 1; i <= 10; i++) {
            ProductoCreate p = new ProductoCreate();
            p.setNombre("Producto " + i);
            p.setPrecio(100.0 * i);
            p.setDescripcion("Detalle prod " + i);
            p.setStock(50);
            p.setDisponible(true);
            productoService.crear(p);
        }

        // 4) Crear 3 Pedidos (con 2 detalles mínimo cada uno usando los IDs guardados)
        // Pedido 1
        PedidoCreate ped1 = new PedidoCreate();
        ped1.setUsuarioId(1L);
        ped1.setFormaPago(FormaPago.EFECTIVO);

        DetallePedidoCreate d1 = new DetallePedidoCreate();
        d1.setCantidad(2);
        d1.setProductoId(1L);
        DetallePedidoCreate d2 = new DetallePedidoCreate();
        d2.setCantidad(1);
        d2.setProductoId(2L);
        ped1.setDetalles(List.of(d1, d2));
        pedidoService.crear(ped1);

        // Pedido 2
        PedidoCreate ped2 = new PedidoCreate();
        ped2.setUsuarioId(1L);
        ped2.setFormaPago(FormaPago.TARJETA);

        DetallePedidoCreate d3 = new DetallePedidoCreate();
        d3.setCantidad(5);
        d3.setProductoId(3L);
        DetallePedidoCreate d4 = new DetallePedidoCreate();
        d4.setCantidad(1);
        d4.setProductoId(4L);
        ped2.setDetalles(List.of(d3, d4));
        pedidoService.crear(ped2);

        // Pedido 3
        PedidoCreate ped3 = new PedidoCreate();
        ped3.setUsuarioId(2L);
        ped3.setFormaPago(FormaPago.TRANSFERENCIA);

        DetallePedidoCreate d5 = new DetallePedidoCreate();
        d5.setCantidad(3);
        d5.setProductoId(5L);
        DetallePedidoCreate d6 = new DetallePedidoCreate();
        d6.setCantidad(2);
        d6.setProductoId(6L);
        ped3.setDetalles(List.of(d5, d6));
        pedidoService.crear(ped3);

        System.out.println("====== CARGA COMPLETADA EXITOSAMENTE Y COMPILANDO ======");
    }
}