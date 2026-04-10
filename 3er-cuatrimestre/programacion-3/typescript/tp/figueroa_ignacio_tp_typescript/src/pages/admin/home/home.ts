import '../../../main';
import { logout } from '../../../utils/auth';
import { navigateTo } from '../../../utils/navigate';

const logoutBtn = document.getElementById('logoutButton');
if (logoutBtn) {
  logoutBtn.addEventListener('click', () => {
    logout();
    navigateTo('/src/pages/auth/login/login.html');
  });
}
