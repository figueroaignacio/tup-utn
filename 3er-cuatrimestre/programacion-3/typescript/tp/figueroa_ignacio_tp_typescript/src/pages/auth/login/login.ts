import '../../../main';
import { getUsers, setCurrentUser } from '../../../utils/auth';
import { navigateTo } from '../../../utils/navigate';
import { Rol } from '../../../types/Rol';

const form = document.getElementById('form') as HTMLFormElement;

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
    const foundUser = users.find(u => u.email === email && u.password === password);

    if (foundUser) {
      const userSession = { ...foundUser };
      delete userSession.password;

      setCurrentUser(userSession);

      alert(`Bienvenido, ${foundUser.email}`);
      
      if (foundUser.rol === Rol.ADMIN) {
        navigateTo('/src/pages/admin/home/home.html');
      } else {
        navigateTo('/src/pages/client/home/home.html');
      }
    } else {
      alert("Credenciales incorrectas.");
    }
  });
}
