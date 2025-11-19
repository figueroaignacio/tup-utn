package Ejercicio1;

public class DemoInventario {

    public static void ejecutar() {
        Inventario inv = new Inventario();

        Producto p1 = new Producto("P001", "Arroz 1kg", 1500, 20, CategoriaProducto.ALIMENTOS);
        Producto p2 = new Producto("P002", "Auriculares", 2500, 10, CategoriaProducto.ELECTRONICA);
        Producto p3 = new Producto("P003", "Remera", 1200, 30, CategoriaProducto.ROPA);
        Producto p4 = new Producto("P004", "Plancha", 4500, 5, CategoriaProducto.HOGAR);
        Producto p5 = new Producto("P005", "Galletitas", 900, 50, CategoriaProducto.ALIMENTOS);

        inv.agregarProducto(p1);
        inv.agregarProducto(p2);
        inv.agregarProducto(p3);
        inv.agregarProducto(p4);
        inv.agregarProducto(p5);

        System.out.println("--- Listar productos ---");
        inv.listarProductos();

        System.out.println("\n--- Buscar P002 ---");
        Producto buscado = inv.buscarProductoPorId("P002");
        if (buscado != null) {
            buscado.mostrarInfo();
        }

        System.out.println("\n--- Filtrar ALIMENTOS ---");
        inv.filtrarPorCategoria(CategoriaProducto.ALIMENTOS).forEach(Producto::mostrarInfo);

        System.out.println("\n--- Eliminar P004 ---");
        inv.eliminarProducto("P004");
        inv.listarProductos();

        System.out.println("\n--- Actualizar stock P003 a 40 ---");
        inv.actualizarStock("P003", 40);
        inv.buscarProductoPorId("P003").mostrarInfo();

        System.out.println("\n--- Total stock ---");
        System.out.println(inv.obtenerTotalStock());

        System.out.println("\n--- Producto con más stock ---");
        Producto mayor = inv.obtenerProductoConMayorStock();
        if (mayor != null) {
            mayor.mostrarInfo();
        }

        System.out.println("\n--- Productos entre $1000 y $3000 ---");
        inv.filtrarProductosPorPrecio(1000, 3000).forEach(Producto::mostrarInfo);

        System.out.println("\n--- Categorías disponibles ---");
        inv.mostrarCategoriasDisponibles();
    }
}


