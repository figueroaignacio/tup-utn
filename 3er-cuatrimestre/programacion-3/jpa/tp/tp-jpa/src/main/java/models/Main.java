package models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] presumption) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidad");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // 4.c Persistir 3 Categorías
            Categoria c1 = Categoria.builder().nombre("Comida").descripcion("Gastr.").build();
            Categoria c2 = Categoria.builder().nombre("Bebida").descripcion("Líquidos").build();
            Categoria c3 = Categoria.builder().nombre("Postre").descripcion("Dulces").build();
            em.persist(c1);
            em.persist(c2);
            em.persist(c3);

            // 4.d Persistir 10 productos
            List<Producto> productos = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                Categoria cat = (i <= 4) ? c1 : (i <= 7) ? c2 : c3;
                Producto p = Producto.builder()
                        .nombre("Producto " + i).precio(100.0 * i).descripcion("Desc " + i)
                        .stock(10 + i).imagen("img" + i + ".png").disponible(true).categoria(cat)
                        .build();
                em.persist(p);
                productos.add(p);
            }

            // 4.a Persistir 2 Usuarios
            Usuario u1 = Usuario.builder().nombre("Edgar").apellido("Figueroa").mail("edgar@mail.com").celular("123").contraseña("123").rol(Rol.ADMIN).build();
            Usuario u2 = Usuario.builder().nombre("Ignacio").apellido("Perez").mail("nacho@mail.com").celular("456").contraseña("456").rol(Rol.USUARIO).build();
            em.persist(u1);
            em.persist(u2);

            // 4.b Persistir 3 Pedidos (con al menos 2 detalles cada uno)
            Pedido ped1 = Pedido.builder().fecha(LocalDate.now()).estado(Estado.PENDIENTE).formaPago(FormaPago.EFECTIVO).usuario(u1).build();
            ped1.addDetallePedido(2, productos.get(0));
            ped1.addDetallePedido(1, productos.get(1));

            Pedido ped2 = Pedido.builder().fecha(LocalDate.now()).estado(Estado.CONFIRMADO).formaPago(FormaPago.TARJETA).usuario(u1).build();
            ped2.addDetallePedido(1, productos.get(2));
            ped2.addDetallePedido(3, productos.get(3));

            Pedido ped3 = Pedido.builder().fecha(LocalDate.now()).estado(Estado.PENDIENTE).formaPago(FormaPago.TRANSFERENCIA).usuario(u2).build();
            ped3.addDetallePedido(1, productos.get(4));
            ped3.addDetallePedido(1, productos.get(5));

            em.persist(ped1);
            em.persist(ped2);
            em.persist(ped3);
            em.getTransaction().commit();

            // 5. Actualizar al menos 2 productos
            em.getTransaction().begin();
            Producto prodA = em.find(Producto.class, productos.get(0).getId());
            Producto prodB = em.find(Producto.class, productos.get(1).getId());
            prodA.setPrecio(1500.0);
            prodB.setStock(99);
            em.getTransaction().commit();

            // 6. Buscar Usuario por id
            Usuario buscadoPorId = em.find(Usuario.class, u1.getId());
            System.out.println("Encontrado por ID: " + buscadoPorId.getNombre());

            // 7. Buscar Usuario por mail
            Usuario buscadoPorMail = em.createQuery("SELECT u FROM Usuario u WHERE u.mail = :email", Usuario.class)
                    .setParameter("email", "nacho@mail.com")
                    .getSingleResult();
            System.out.println("Encontrado por Mail: " + buscadoPorMail.getNombre());

            // 8. Borrar 1 producto
            em.getTransaction().begin();
            Producto prodBorrar = em.find(Producto.class, productos.get(9).getId()); // Borra el décimo
            em.remove(prodBorrar);
            em.getTransaction().commit();

        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}