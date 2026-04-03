function cargarCategorias() {
  const listaCategorias = document.getElementById("lista-categorias");

  listaCategorias.innerHTML = "";

  categorias.forEach((categoria) => {
    const li = document.createElement("li");
    li.classList.add("sidebar__item");
    const a = document.createElement("a");
    a.classList.add("sidebar__link");
    a.textContent = categoria;
    a.href = "#";
    li.appendChild(a);
    listaCategorias.appendChild(li);
  });
}

function cargarProductos() {
  const contenedorProductos = document.getElementById("contenedor-productos");

  contenedorProductos.innerHTML = "";

  productos.forEach((producto) => {
    const article = document.createElement("article");
    article.classList.add("product-card");

    article.innerHTML = `
      <img src="${producto.imagen}" alt="${producto.nombre}" class="product-card__image" />
      <div class="product-card__info">
        <h3 class="product-card__title">${producto.nombre}</h3>
        <p class="product-card__description">${producto.descripcion}</p>
        <span class="product-card__price">$${producto.precio}</span>
        <button class="product-card__button">Agregar al carrito</button>
      </div>
    `;

    contenedorProductos.appendChild(article);
  });
}


cargarCategorias();
cargarProductos();
