# Trabajo Práctico 4: Estructuras Repetitivas
# Alumno: Ignacio Figueroa - Comisión 7

"""
1) Crea un programa que imprima en pantalla todos los números enteros desde 0 hasta 100 
(incluyendo ambos extremos), en orden creciente, mostrando un número por línea. 
"""

for i in range(101):
  print(i)

"""
2) Desarrolla un programa que solicite al usuario un número entero y determine la cantidad de 
dígitos que contiene.
"""

numero = input("Ingrese un numero: ")
cantidad_digitos = 0

for i in numero: 
  cantidad_digitos += 1

print(f"El numero tiene {cantidad_digitos} dígitos")


"""
3) Escribe un programa que sume todos los números enteros comprendidos entre dos valores 
dados por el usuario, excluyendo esos dos valores.
"""

x = int(input("Ingrese el primer valor: "))
y = int(input("Ingrese el segundo valor: "))

if x > y:
    x, y = y, x

suma = 0

for i in range(x + 1, y):
    suma += i

print(f"La suma de los números entre {x} y {y} (excluyéndolos) es: {suma}")

"""
4) Elabora un programa que permita al usuario ingresar números enteros y los sume en 
secuencia. El programa debe detenerse y mostrar el total acumulado cuando el usuario ingrese 
un 0.
"""

total = 0 
nums = int(input("Ingrese un número (0 para terminar): "))

while nums != 0:
  total += nums
  nums = int(input("Ingrese un número (0 para terminar): "))

print(f"El total acumulado es: {total}")

"""
5) Crea un juego en el que el usuario deba adivinar un número aleatorio entre 0 y 9. Al final, el 
programa debe mostrar cuántos intentos fueron necesarios para acertar el número. 
"""

import random

numero_aleatorio = random.randint(0, 9)
intentos = 0 
adivinaste = False

while not adivinaste:
  intento_usuario = int(input("Adiniva el numero entre el 0 y el 9: "))
  intentos += 1

  if intento_usuario == numero_aleatorio:
    adivinaste = True
    print(f"Bien!, adivinaste el número en {intentos} intentos")

  if intento_usuario < numero_aleatorio:
    print("El numero es mayor, intentalo de nuevo")

  if intento_usuario > numero_aleatorio:
    print("El numero es menor, intentalo de nuevo")

"""
6) Desarrolla un programa que imprima en pantalla todos los números pares comprendidos 
entre 0 y 100, en orden decreciente. 
"""

for numero in range(100, -1, -1):
  if numero % 2 != 0:
    print(numero)

"""
7) Crea un programa que calcule la suma de todos los números comprendidos entre 0 y un 
número entero positivo indicado por el usuario.
"""

limite = int(input("Ingresa un número entero positivo: "))

suma_total = 0

for numero in range(limite + 1):
  suma_total += numero

print(f"La suma de los numeros entre 0 y {limite} es: {suma_total}")

"""
8) Escribe un programa que permita al usuario ingresar 100 números enteros. Luego, el 
programa debe indicar cuántos de estos números son pares, cuántos son impares, cuántos son 
negativos y cuántos son positivos. (Nota: para probar el programa puedes usar una cantidad 
menor, pero debe estar preparado para procesar 100 números con un solo cambio). 
"""

CANTIDAD_NUMEROS = 100

pares = 0
impares = 0
positivos = 0 
negativos = 0

for i in range(CANTIDAD_NUMEROS):
  numero = int(input(f"Ingrese el numero #{i + 1}: "))

  if numero % 2 == 0:
    pares += 1

  if numero % 2 != 0:
    impares += 1

  if numero > 0:
    positivos += 1

  if numero < 0:
    positivos += 1

print("========== Resultados ==========")
print(f"Pares: {pares}")
print(f"Impares: {impares}")
print(f"Positivos: {positivos}")
print(f"Negativos: {negativos}")


"""
9) Elabora un programa que permita al usuario ingresar 100 números enteros y luego calcule la 
media de esos valores. (Nota: puedes probar el programa con una cantidad menor, pero debe 
poder procesar 100 números cambiando solo un valor). 
"""

CANTIDAD_NUMEROS = 100

suma_total = 0

for i in range(CANTIDAD_NUMEROS):
  num = int(input(f"Ingrese el numero #{i + 1}: "))
  suma_total += num

media = suma_total / CANTIDAD_NUMEROS

print(f"La suma de los {CANTIDAD_NUMEROS} numero ingresados es: {media}")

"""
10) Escribe un programa que invierta el orden de los dígitos de un número ingresado por el 
usuario. Ejemplo: si el usuario ingresa 547, el programa debe mostrar 745.
"""

numero = input("Ingresa un numero: ")
numero_invertido = ""

for i in range(len(numero) - 1, -1, -1):
  numero_invertido += numero[i]

print(f"{numero_invertido}")
