import type { Product } from "../types/product";
import type { Icategoria } from "../types/categoria";

export const PRODUCTS: Product[] = [
  {
    id: 1,
    name: "Pizza Muzzarella",
    price: 4500,
    category: "Pizzas",
    image: "/pizza.png",
  },
  {
    id: 2,
    name: "Pizza Napolitana",
    price: 5200,
    category: "Pizzas",
    image: "/pizza.png",
  },
  {
    id: 3,
    name: "Pizza 4 Quesos",
    price: 6800,
    category: "Pizzas",
    image: "/pizza.png",
  },
  {
    id: 4,
    name: "Hamburguesa Clásica",
    price: 3800,
    category: "Hamburguesas",
    image: "/hamburguesa.png",
  },
  {
    id: 5,
    name: "Hamburguesa BBQ",
    price: 5100,
    category: "Hamburguesas",
    image: "/hamburguesa.png",
  },
  {
    id: 6,
    name: "Hamburguesa Veggie",
    price: 4200,
    category: "Hamburguesas",
    image: "/hamburguesa.png",
  },
  {
    id: 7,
    name: "Coca-Cola",
    price: 1200,
    category: "Bebidas",
    image: "/bebida.png",
  },
  {
    id: 8,
    name: "Jugo Natural",
    price: 1800,
    category: "Bebidas",
    image: "/bebida.png",
  },
  {
    id: 9,
    name: "Torta Rogel",
    price: 3500,
    category: "Postres",
    image: "/postre.png",
  },
  {
    id: 10,
    name: "Brownie con Helado",
    price: 2200,
    category: "Postres",
    image: "/postre.png",
  },
  {
    id: 11,
    name: "Empanadas Carne",
    price: 3000,
    category: "Empanadas",
    image: "/empanada.png",
  },
  {
    id: 12,
    name: "Ensalada César",
    price: 3200,
    category: "Ensaladas",
    image: "/ensalada.png",
  },
];

export function getCategories(): Icategoria[] {
  const uniqueCategories = [...new Set(PRODUCTS.map((p) => p.category))];
  return uniqueCategories.map((name, index) => ({
    id: index + 1,
    name: name,
  }));
}
