import type { CartItem } from '../../../types/product'

const cartItemsContainer = document.getElementById(
  'cart-items',
) as HTMLDivElement
const cartTotalContainer = document.getElementById(
  'cart-total',
) as HTMLDivElement

function renderCart() {
  const cartJson = localStorage.getItem('cart')
  const cart: CartItem[] = cartJson ? JSON.parse(cartJson) : []

  cartItemsContainer.innerHTML = ''

  if (cart.length === 0) {
    cartItemsContainer.innerHTML = `
      <div class="cart-empty">
        <i class="fas fa-shopping-cart cart-empty__icon"></i>
        <p class="cart-empty__text">Tu carrito está vacío</p>
        <a href="../home/home.html" class="header__link" style="display: inline-flex; margin-top: 1rem; background: var(--primary-color); color: white;">
          Ir a comprar algo rico
        </a>
      </div>
    `
    cartTotalContainer.innerHTML = ''
    return
  }

  let totalGeneral = 0

  cart.forEach((item) => {
    const subtotal = item.price * item.quantity
    totalGeneral += subtotal

    const itemElement = document.createElement('div')
    itemElement.className = 'cart-item'
    itemElement.innerHTML = `
            <div class="cart-item__info">
                <h3 class="cart-item__name">${item.name}</h3>
                <span class="cart-item__price">$${item.price.toLocaleString()} x ${item.quantity}</span>
            </div>
            <div class="cart-item__actions">
                 <span class="cart-item__subtotal">$${subtotal.toLocaleString()}</span>
            </div>
        `
    cartItemsContainer.appendChild(itemElement)
  })

  cartTotalContainer.innerHTML = `
    <span class="cart-total__label">Total a pagar:</span>
    <span class="cart-total__amount">$${totalGeneral.toLocaleString()}</span>
  `
}

renderCart()
