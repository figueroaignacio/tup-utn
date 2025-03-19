# Trabajo Práctico Secuenciales - Programación I
# Nombre: Ignacio Figueroa | Comisión 7

"""
 1 - Crear un programa que imprima por pantalla el mensaje: “Hola Mundo!”. 
"""

# SOLUCIÓN
print("Hola mundo!")

"""
 2 - Crear un programa que pida al usuario su nombre e imprima por pantalla un saludo usando 
 el nombre ingresado. Por ejemplo: si el usuario ingresa “Marcos”, el programa debe imprimir 
 por pantalla “Hola Marcos!”. Consejo: esto será más sencillo si utilizas print(f…) para 
 realizar la impresión por pantalla.
"""

# SOLUCIÓN
nombre = input("Ingrese su nombre: ")

print(f"Hola, {nombre}")

"""
 3 - Crear un programa que pida al usuario su nombre, apellido, edad y lugar de residencia e 
 imprima por pantalla una oración con los datos ingresados. Por ejemplo: si el usuario ingresa 
 “Marcos”, “Pérez”, “30” y “Argentina”, el programa debe imprimir “Soy Marcos Pérez, tengo 30 
 años y vivo en Argentina”. Consejo: esto será más sencillo si utilizas print(f…) para realizar 
 la impresión por pantalla. 
"""

# SOLUCIÓN
nombre = input("Ingrese su nombre completo: ")
edad = input("Ingrese su edad: ")  
residencia = input("Ingrese su lugar de residencia actual: ")

print(f"Soy {nombre}, tengo {edad} años y vivo en {residencia}.")

"""
 4 - Crear un programa que pida al usuario el radio de un círculo e imprima por pantalla su área y 
 su perímetro.
"""

# SOLUCIÓN
import math

radio = float(input("Ingrese al radio del círculo: "))
area = math.pi * radio**2
perimetro = 2 * math.pi * radio

print(f"El área del círculo es: {area}")
print(f"El perímetro del círculo es: {perimetro}")

"""
 5 - Crear un programa que pida al usuario una cantidad de segundos e imprima por pantalla a 
 cuántas horas equivale. 
"""

# SOLUCIÓN
segundos = int(input("Ingrese la cantidad de segundos: "))

horas = segundos / 3600

print(f"{segundos} segundos equivalen a {horas:.2f} horas.")

"""
 6 - Crear un programa que pida al usuario un número e imprima por pantalla la tabla de 
 multiplicar de dicho número.
"""

# SOLUCIÓN
numero = int(input("Ingrese un número: "))

print(f"La tabla de multiplicar de {numero} es: ")
for i in range(1, 11):
  print(f"{numero} x {i} = {numero * i}")

"""
 7 - Crear un programa que pida al usuario dos números enteros distintos del 0 y muestre por 
 pantalla el resultado de sumarlos, dividirlos, multiplicarlos y restarlos. 
"""

# SOLUCIÓN
a = int(input("Ingrese el primer número (distinto a 0): "))
b = int(input("Ingrese el segundo número (distinto a 0): "))

if a == 0 or b == 0:
  print("Los números deben ser distintos a 0.")
else:
  suma = a + b
  resta = a - b
  multiplicacion = a * b
  division = a / b

  print("===============")
  print(f"Suma: {a} + {b} = {suma}")
  print("===============")
  print(f"Resta: {a} - {b} = {resta}")
  print("===============")
  print(f"Multiplicación: {a} x {b} = {multiplicacion}")
  print("===============")
  print(f"División: {a} / {b} = {division}")
  print("===============")

"""
 8 - Crear un programa que pida al usuario su altura y su peso e imprima por pantalla su índice 
 de masa corporal. 
"""

# SOLUCIÓN
peso = float(input("Ingrese su peso en kg: "))
altura = float(input("Ingrese su altura en metros: "))

imc = peso / (altura ** 2)

print(f"Tu Índice de Masa Corporal (IMC) es: {imc:.2f}")

"""
 9 - Crear un programa que pida al usuario una temperatura en grados Celsius e imprima por 
 pantalla su equivalente en grados Fahrenheit. Tener en cuenta la siguiente equivalencia: 
"""

# SOLUCIÓN
celsius = float(input("Ingrese la temperatura en grados a celsius: "))

farenheit = (celsius * 9/5) + 32

print(f"{celsius}°C equivalen a {farenheit:.2f}°F")

"""
 10 - Crear un programa que pida al usuario  3 números e imprima por pantalla el promedio de 
 dichos números. 
"""

# SOLUCIÓN
a = float(input("Ingrese el primer numero del promedio: "))
b = float(input("Ingrese el segunda numero del promedio: "))
c = float(input("Ingrese el tercera numero del promedio: "))

calculo = a + b + c 
promedio = calculo / 3

print(f"El promedio es : {promedio:.2f}")


