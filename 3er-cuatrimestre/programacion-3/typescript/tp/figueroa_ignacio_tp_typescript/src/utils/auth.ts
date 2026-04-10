import type { IUser } from '../types/IUser';

export const getUsers = (): IUser[] => {
  const users = localStorage.getItem('users');
  return users ? JSON.parse(users) : [];
};

export const saveUser = (user: IUser): void => {
  const users = getUsers();
  users.push(user);
  localStorage.setItem('users', JSON.stringify(users));
};

export const getCurrentUser = (): IUser | null => {
  const userData = localStorage.getItem('userData');
  return userData ? JSON.parse(userData) : null;
};

export const setCurrentUser = (user: IUser): void => {
  localStorage.setItem('userData', JSON.stringify(user));
};

export const logout = (): void => {
  localStorage.removeItem('userData');
};
