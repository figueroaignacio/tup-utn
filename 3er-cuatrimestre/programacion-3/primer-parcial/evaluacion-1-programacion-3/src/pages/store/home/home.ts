import { PRODUCTS, getCategories } from '../../../data/data'
import type { CartItem, Product } from '../../../types/product'

const productsGrid = document.getElementById('products-grid') as HTMLDivElement
const categoriesList = document.getElementById(
  'categories-list',
) as HTMLDivElement
const searchInput = document.getElementById('search-input') as HTMLInputElement

let currentFilter = {
  name: '',
  category: 'Todas',
}

function renderCategories() {
  categoriesList.innerHTML = ''
  const categories = getCategories()

  const allButton = document.createElement('button')
  allButton.className = `filters__category-btn ${currentFilter.category === 'Todas' ? 'filters__category-btn--active' : ''}`
  allButton.textContent = 'Todas'
  allButton.addEventListener('click', () => {
    currentFilter.category = 'Todas'
    renderCategories()
    applyFilters()
  })
  categoriesList.appendChild(allButton)

  categories.forEach((cat) => {
    const btn = document.createElement('button')
    btn.className = `filters__category-btn ${currentFilter.category === cat.name ? 'filters__category-btn--active' : ''}`
    btn.textContent = cat.name
    btn.addEventListener('click', () => {
      currentFilter.category = cat.name
      renderCategories()
      applyFilters()
    })
    categoriesList.appendChild(btn)
  })
}

function renderProducts(products: Product[]) {
  productsGrid.innerHTML = ''

  if (products.length === 0) {
    productsGrid.innerHTML = `
      <div class="products-grid__empty">
        <i class="fas fa-search-minus" style="font-size: 3rem; margin-bottom: 1rem; display: block;"></i>
        No se encontraron productos que coincidan con tu búsqueda.
      </div>
    `
    return
  }

  products.forEach((product) => {
    const card = document.createElement('div')
    card.className = 'product-card'
    card.innerHTML = `
            <img class="product-card__image" src="${product.image}" alt="${product.name}">
            <div class="product-card__content">
                <h3 class="product-card__title">${product.name}</h3>
                <p class="product-card__category">
                    <i class="fas fa-tag"></i> ${product.category}
                </p>
                <div class="product-card__footer">
                    <span class="product-card__price">$${product.price.toLocaleString()}</span>
                    <button class="product-card__button add-to-cart" data-id="${product.id}">
                        <i class="fas fa-plus"></i> Agregar
                    </button>
                </div>
            </div>
        `

    const addButton = card.querySelector('.add-to-cart') as HTMLButtonElement
    addButton.addEventListener('click', () => addToCart(product.id, addButton))

    productsGrid.appendChild(card)
  })
}

function applyFilters() {
  const filtered = PRODUCTS.filter((p) => {
    const matchesName = p.name
      .toLowerCase()
      .includes(currentFilter.name.toLowerCase())
    const matchesCategory =
      currentFilter.category === 'Todas' ||
      p.category === currentFilter.category
    return matchesName && matchesCategory
  })
  renderProducts(filtered)
}

function addToCart(productId: number, button: HTMLButtonElement) {
  const cartJson = localStorage.getItem('cart')
  let cart: CartItem[] = cartJson ? JSON.parse(cartJson) : []

  const product = PRODUCTS.find((p) => p.id === productId)
  if (!product) return

  const existingItem = cart.find((item) => item.id === productId)

  if (existingItem) {
    existingItem.quantity += 1
  } else {
    cart.push({ ...product, quantity: 1 })
  }

  localStorage.setItem('cart', JSON.stringify(cart))

  const originalHtml = button.innerHTML
  button.innerHTML = '<i class="fas fa-check"></i> ¡Agregado!'
  button.disabled = true
  setTimeout(() => {
    button.innerHTML = originalHtml
    button.disabled = false
  }, 1000)
}

searchInput.addEventListener('input', (e) => {
  currentFilter.name = (e.target as HTMLInputElement).value
  applyFilters()
})

renderCategories()
renderProducts(PRODUCTS)
