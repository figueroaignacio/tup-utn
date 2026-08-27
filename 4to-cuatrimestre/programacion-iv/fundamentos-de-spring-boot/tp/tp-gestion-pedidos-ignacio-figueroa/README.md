# TP Fundamentos de Spring — Sistema de Gestión de Pedidos

Programación IV — Tecnicatura Universitaria en Programación (UTN)

---

## 1. Cómo arrancarlo en IntelliJ

**Opción A — usar este proyecto tal cual**

1. Descomprimí el zip.
2. IntelliJ → `File > Open` → elegí la carpeta `gestion-pedidos` (la que tiene el `pom.xml`).
3. Cuando pregunte, aceptá **Load Maven Project / Trust Project**. Esperá a que baje las dependencias (barra de abajo).
4. `File > Project Structure > Project SDK` → **Java 21** (si tenés 17, cambiá `<java.version>21</java.version>` a `17` en el `pom.xml`).
5. **Habilitar Lombok**: `Settings > Build, Execution, Deployment > Compiler > Annotation Processors` → tildar *Enable annotation processing*. Sin esto no compilan los getters/setters.
6. Ejecutar `GestionPedidosApplication` (el ▶ verde al lado del `main`).

**Opción B — generar el proyecto vos mismo (esto es literalmente el punto 1 del TP)**

1. Andá a https://start.spring.io
2. Maven · Java · Spring Boot 3.4.x · Jar · Java 21
   Group: `com.utn` — Artifact: `gestion-pedidos`
3. Dependencias: **Spring Web**, **Spring Data JPA**, **Lombok**, **H2 Database**, **Spring Boot DevTools**
4. Generate → descomprimir → abrir en IntelliJ.
5. Copiá la carpeta `src/main/java/com/utn/gestionpedidos` y el `application.properties` de este proyecto adentro del tuyo.

## 2. Qué vas a ver al ejecutar

En la consola aparece el log del `DataLoader` con los totales de los 3 pedidos, y las sentencias SQL que genera Hibernate.

- Consola H2: http://localhost:8080/h2-console
  - JDBC URL: `jdbc:h2:mem:pedidosdb` — User: `sa` — Password: *(vacío)*
- API: http://localhost:8080/api/pedidos (o abrí `requests.http` en IntelliJ y tocá los ▶)

## 3. Estructura

```
com.utn.gestionpedidos
├── GestionPedidosApplication.java   → @SpringBootApplication (arranca el ApplicationContext)
├── config
│   ├── AppProperties.java           → @ConfigurationProperties("app")
│   └── DataLoader.java              → CommandLineRunner: instancia todo desde DTOs (punto 3)
├── controllers                      → @RestController (capa web, opcional para el TP)
├── dtos
│   ├── categoria/  CategoriaCreate · CategoriaDto · CategoriaEdit
│   ├── detallePedido/  DetallePedidoCreate · DetallePedidoDto
│   ├── pedido/  PedidoCreate* · PedidoDto · PedidoEdit
│   ├── producto/  ProductoCreate · ProductoDto · ProductoEdit
│   └── usuario/  UsuarioCreate · UsuarioDto · UsuarioEdit
├── entities                         → @Entity (Base, Usuario, Pedido, DetallePedido, Producto, Categoria)
├── enums                            → Rol, Estado, FormaPago
├── exceptions                       → NotFoundException
├── interfaces                       → Calculable
├── mappers                          → @Component (Entidad ↔ DTO)
├── repositories                     → @Repository (extends JpaRepository)
└── services                         → @Service (lógica de negocio)
```

\* `PedidoCreate` **no** figura en el árbol del PDF, pero hace falta para poder crear pedidos.
Si tu profe exige el árbol exacto: borrá `PedidoCreate.java` y usá `PedidoEdit` como DTO de entrada
para crear (agregándole un `usuarioId`).

## 4. Los 4 conceptos del marco teórico, dónde están en el código

| Concepto | Dónde mirarlo |
|---|---|
| **Application Context** | `GestionPedidosApplication.main()`. `SpringApplication.run(...)` crea el contenedor, escanea el paquete, instancia cada bean y resuelve sus dependencias. |
| **Beans** | Cada clase con `@Service`, `@Repository`, `@Component`, `@RestController`. También los que crea Spring solo: `DataSource`, `EntityManager`, `Tomcat`. |
| **Inyección de dependencias** | Todos los constructores: `PedidoService(PedidoRepository, UsuarioService, ProductoService, PedidoMapper)`. Campos `final`, sin `@Autowired` (innecesario desde Spring 4.3 con un solo constructor). |
| **Estereotipos** | `@Repository` = acceso a datos · `@Service` = reglas de negocio · `@Component` = bean genérico (mappers, AppProperties, DataLoader) · `@RestController` = capa web. |

## 5. Flujo de una operación

```
DataLoader / Controller  →  ProductoCreate (DTO)
        ↓
ProductoService          →  valida, busca la Categoría, delega en el Mapper
        ↓
ProductoMapper           →  DTO ➜ entidad Producto
        ↓
ProductoRepository       →  save() ➜ INSERT en H2
        ↓
ProductoMapper           →  entidad ➜ ProductoDto (lo que sale de la app)
```

## 6. Conclusiones esperadas (para el informe)

- **Inyección por constructor**: los campos son `final`, la clase no puede existir sin sus dependencias (no hay `NullPointerException` por dependencia sin setear), se detectan las dependencias circulares al arrancar y los tests pueden pasar mocks sin reflexión. Con `@Autowired` en el campo nada de eso se cumple.
- **Estereotipos**: son todos `@Component` por dentro, pero comunican la responsabilidad de la clase y habilitan comportamiento extra (`@Repository` traduce excepciones de persistencia a la jerarquía `DataAccessException` de Spring).
- **Properties**: la configuración vive en `application.properties`, no hardcodeada. `AppProperties` la tipa con `@ConfigurationProperties`, así se puede cambiar el comportamiento (ej. `app.cargar-datos-iniciales=false`) sin tocar una línea de Java.
- **DTOs**: separan el modelo de persistencia del contrato de la API. Caso concreto: `UsuarioDto` no tiene `contrasenia`, así que es imposible filtrarla por accidente. Además evitan las recursiones infinitas al serializar relaciones bidireccionales.
