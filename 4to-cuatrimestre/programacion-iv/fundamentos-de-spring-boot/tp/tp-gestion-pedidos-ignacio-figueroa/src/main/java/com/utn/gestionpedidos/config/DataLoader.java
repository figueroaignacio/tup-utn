package com.utn.gestionpedidos.config;

import com.utn.gestionpedidos.dtos.categoria.CategoriaCreate;
import com.utn.gestionpedidos.dtos.categoria.CategoriaDto;
import com.utn.gestionpedidos.dtos.detallePedido.DetallePedidoCreate;
import com.utn.gestionpedidos.dtos.pedido.PedidoCreate;
import com.utn.gestionpedidos.dtos.pedido.PedidoDto;
import com.utn.gestionpedidos.dtos.producto.ProductoCreate;
import com.utn.gestionpedidos.dtos.producto.ProductoDto;
import com.utn.gestionpedidos.dtos.usuario.UsuarioCreate;
import com.utn.gestionpedidos.dtos.usuario.UsuarioDto;
import com.utn.gestionpedidos.enums.FormaPago;
import com.utn.gestionpedidos.enums.Rol;
import com.utn.gestionpedidos.services.CategoriaService;
import com.utn.gestionpedidos.services.PedidoService;
import com.utn.gestionpedidos.services.ProductoService;
import com.utn.gestionpedidos.services.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * PUNTO 3 DEL TP: "Instanciar a partir de DTOs".
 *
 * CommandLineRunner es una interface de Spring Boot: el metodo run() se
 * ejecuta UNA VEZ, apenas termina de levantar el ApplicationContext.
 * Es el lugar tipico para cargar datos de prueba.
 *
 * Fijate que aca NO se instancia ninguna entidad con "new": todo entra
 * por los DTOs Create y son los services los que arman las entidades.
 */
@Component
public class DataLoader implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataLoader.class);

    private final CategoriaService categoriaService;
    private final ProductoService productoService;
    private final UsuarioService usuarioService;
    private final PedidoService pedidoService;
    private final AppProperties appProperties;

    // Inyeccion por constructor de 5 beans
    public DataLoader(CategoriaService categoriaService,
                      ProductoService productoService,
                      UsuarioService usuarioService,
                      PedidoService pedidoService,
                      AppProperties appProperties) {
        this.categoriaService = categoriaService;
        this.productoService = productoService;
        this.usuarioService = usuarioService;
        this.pedidoService = pedidoService;
        this.appProperties = appProperties;
    }

    @Override
    public void run(String... args) {
        if (!appProperties.isCargarDatosIniciales()) {
            log.info("Carga de datos iniciales desactivada (app.cargar-datos-iniciales=false)");
            return;
        }

        log.info("=== {} v{} - cargando datos iniciales ===",
                appProperties.getNombre(), appProperties.getVersion());

        // ---------- 3 CATEGORIAS ----------
        CategoriaDto electronica = categoriaService.crear(
                new CategoriaCreate("Electronica", "Celulares, notebooks y accesorios"));
        CategoriaDto indumentaria = categoriaService.crear(
                new CategoriaCreate("Indumentaria", "Ropa y calzado"));
        CategoriaDto hogar = categoriaService.crear(
                new CategoriaCreate("Hogar", "Articulos para la casa"));

        // ---------- 10 PRODUCTOS ----------
        ProductoDto notebook = productoService.crear(new ProductoCreate(
                "Notebook Lenovo IdeaPad", 950000.0, "14 pulgadas, 16GB RAM, SSD 512GB",
                12, "notebook.jpg", electronica.id()));
        ProductoDto celular = productoService.crear(new ProductoCreate(
                "Celular Samsung A55", 620000.0, "128GB, 8GB RAM",
                25, "celular.jpg", electronica.id()));
        ProductoDto auriculares = productoService.crear(new ProductoCreate(
                "Auriculares Bluetooth JBL", 85000.0, "Inalambricos con estuche de carga",
                40, "auriculares.jpg", electronica.id()));
        ProductoDto monitor = productoService.crear(new ProductoCreate(
                "Monitor Samsung 24\"", 280000.0, "Full HD 75Hz",
                8, "monitor.jpg", electronica.id()));

        ProductoDto remera = productoService.crear(new ProductoCreate(
                "Remera algodon", 18000.0, "Talles S al XL",
                100, "remera.jpg", indumentaria.id()));
        ProductoDto jean = productoService.crear(new ProductoCreate(
                "Jean clasico", 45000.0, "Corte recto azul",
                60, "jean.jpg", indumentaria.id()));
        ProductoDto zapatillas = productoService.crear(new ProductoCreate(
                "Zapatillas urbanas", 95000.0, "Suela de goma, unisex",
                35, "zapatillas.jpg", indumentaria.id()));

        ProductoDto cafetera = productoService.crear(new ProductoCreate(
                "Cafetera express", 210000.0, "15 bares con espumador",
                15, "cafetera.jpg", hogar.id()));
        ProductoDto juegoSabanas = productoService.crear(new ProductoCreate(
                "Juego de sabanas 2 plazas", 52000.0, "180 hilos",
                50, "sabanas.jpg", hogar.id()));
        ProductoDto lampara = productoService.crear(new ProductoCreate(
                "Lampara de escritorio LED", 32000.0, "Brazo articulado, 3 temperaturas",
                45, "lampara.jpg", hogar.id()));

        // ---------- 2 USUARIOS ----------
        UsuarioDto admin = usuarioService.crear(new UsuarioCreate(
                "Lucia", "Fernandez", "lucia.fernandez@mail.com",
                "3364123456", "admin1234", Rol.ADMIN));
        UsuarioDto cliente = usuarioService.crear(new UsuarioCreate(
                "Martin", "Gomez", "martin.gomez@mail.com",
                "3364987654", "martin1234", Rol.USUARIO));

        // ---------- 3 PEDIDOS (2+ detalles cada uno) ----------
        PedidoDto pedido1 = pedidoService.crear(new PedidoCreate(
                cliente.id(),
                FormaPago.TARJETA,
                List.of(
                        new DetallePedidoCreate(notebook.id(), 1),
                        new DetallePedidoCreate(auriculares.id(), 2)
                )));

        PedidoDto pedido2 = pedidoService.crear(new PedidoCreate(
                cliente.id(),
                FormaPago.TRANSFERENCIA,
                List.of(
                        new DetallePedidoCreate(remera.id(), 3),
                        new DetallePedidoCreate(jean.id(), 1),
                        new DetallePedidoCreate(zapatillas.id(), 1)
                )));

        PedidoDto pedido3 = pedidoService.crear(new PedidoCreate(
                admin.id(),
                FormaPago.EFECTIVO,
                List.of(
                        new DetallePedidoCreate(cafetera.id(), 1),
                        new DetallePedidoCreate(juegoSabanas.id(), 2),
                        new DetallePedidoCreate(lampara.id(), 1)
                )));

        // productos que quedaron sin usar en pedidos, solo para el log
        log.info("Productos cargados: 10 (incluye {} y {})", celular.nombre(), monitor.nombre());
        log.info("Categorias: {} | Usuarios: {} | Pedidos: {}",
                categoriaService.listar().size(),
                usuarioService.listar().size(),
                pedidoService.listar().size());
        log.info("Pedido #{} total: ${}", pedido1.id(), pedido1.total());
        log.info("Pedido #{} total: ${}", pedido2.id(), pedido2.total());
        log.info("Pedido #{} total: ${}", pedido3.id(), pedido3.total());
        log.info("=== Datos iniciales cargados OK. Consola H2: http://localhost:8080/h2-console ===");
    }
}
