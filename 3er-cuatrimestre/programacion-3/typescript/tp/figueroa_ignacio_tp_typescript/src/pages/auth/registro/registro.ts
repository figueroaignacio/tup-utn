import '../../../main';
import type { IUser } from '../../../types/IUser';
import { Rol } from '../../../types/Rol';
import { saveUser, getUsers } from '../../../utils/auth';
import { navigateTo } from '../../../utils/navigate';

const form = document.getElementById('registro-form') as HTMLFormElement;

if (form) {
  form.addEventListener('submit', (e: Event) => {
    e.preventDefault();

    const emailInput = document.getElementById('email') as HTMLInputElement;
    const passwordInput = document.getElementById('password') as HTMLInputElement;

    const email = emailInput.value.trim();
    const password = passwordInput.value.trim();

    if (!email || !password) {
      alert("Por favor, complete todos los campos.");
      return;
    }

    const users = getUsers();
    const userExists = users.some(u => u.email === email);

    if (userExists) {
      alert("El usuario ya existe.");
      return;
    }

    const newUser: IUser = {
      email,
      password,
      rol: Rol.CLIENT
    };

    saveUser(newUser);

    alert("Usuario registrado con éxito. Redirigiendo a Login...");
    navigateTo('/src/pages/auth/login/login.html');
  });
}
