import './style.css';
import { getCurrentUser } from './utils/auth';
import { Rol } from './types/Rol';
import { navigateTo } from './utils/navigate';

const checkRoute = () => {
  const currentPath = window.location.pathname;
  const user = getCurrentUser();

  // Root path redirect
  if (currentPath === '/' || currentPath === '/index.html' || currentPath === '') {
    if (user) {
      if (user.rol === Rol.ADMIN) {
        navigateTo('/src/pages/admin/home/home.html');
      } else {
        navigateTo('/src/pages/client/home/home.html');
      }
    } else {
      navigateTo('/src/pages/auth/login/login.html');
    }
    return;
  }

  // Rutas públicas
  if (currentPath.includes('/login') || currentPath.includes('/registro')) {
    if (user) {
      if (user.rol === Rol.ADMIN) {
        navigateTo('/src/pages/admin/home/home.html');
      } else {
        navigateTo('/src/pages/client/home/home.html');
      }
    }
    return;
  }

  // Rutas protegidas (si no hay user, va al login)
  if (!user) {
    navigateTo('/src/pages/auth/login/login.html');
    return;
  }

  // Validación de roles
  if (currentPath.includes('/admin/') && user.rol !== Rol.ADMIN) {
    navigateTo('/src/pages/client/home/home.html');
    return;
  }

  if (currentPath.includes('/client/') && user.rol !== Rol.CLIENT) {
    navigateTo('/src/pages/admin/home/home.html');
    return;
  }
};

// Ejecutar validación
checkRoute();
