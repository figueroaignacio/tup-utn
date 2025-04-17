# Trabajo Práctico 3: Estructuras condicionales  
# Alumno: Ignacio Figueroa - Comisión 7

"""
1) Escribir un programa que solicite la edad del usuario. Si el usuario es mayor de 18 años, 
deberá mostrar un mensaje en pantalla que diga “Es mayor de edad”. 
"""

edad = int(input("Ingrese su edad: "))

if edad <= 0:
    print("Edad incorrecta.")

if edad > 0 and edad <= 17:
    print("Es menor de edad.")

if edad >= 18:
    print("Es mayor de edad.")

"""
2) Escribir un programa que solicite su nota al usuario. Si la nota es mayor o igual a 6, deberá 
mostrar por pantalla un mensaje que diga “Aprobado”; en caso contrario deberá mostrar el 
mensaje “Desaprobado”. 
"""

nota = float(input("Ingrese su nota: "))

if nota < 0:
  print("Nota incorrecta.")

if nota > 0 and nota <= 5:
  print ("Desaprobado") 

if nota >= 6:
  print("Aprobado")

"""
3) Escribir un programa que permita ingresar solo números pares. Si el usuario ingresa un 
número par, imprimir por en pantalla el mensaje "Ha ingresado un número par"; en caso 
contrario, imprimir por pantalla "Por favor, ingrese un número par". Nota: investigar el uso del 
operador de módulo (%) en Python para evaluar si un número es par o impar. 
"""

numero = int(input("Ingrese un número par: "))

if numero % 2 != 0:
  print("Por favor, ingrese un número par")

if numero % 2 == 0:
  print ("Ha ingresado un número par.")

"""
4) Escribir un programa que solicite al usuario su edad e imprima por pantalla a cuál de las 
siguientes categorías pertenece: 
● Niño/a: menor de 12 años. 
● Adolescente: mayor o igual que 12 años y menor que 18 años. 
● Adulto/a joven: mayor o igual que 18 años y menor que 30 años. 
● Adulto/a: mayor o igual que 30 años.
"""

edad = int(input("Ingrese su edad: "))

if edad < 0:
  print("Por favor, ingrese una edad correcta.")

if edad > 0 and edad < 12:
  print("Pertenece a la categoria: Niño/a")

if edad >= 12 and edad < 18:
  print("Pertenece a la categoria: Adolescente")

if edad >= 18 and edad < 30:
  print("Pertenece a la categoria: Adulto/a joven")

if edad >= 30:
  print("Pertenece a la categoria: Adulto")


"""
5) Escribir un programa que permita introducir contraseñas de entre 8 y 14 caracteres 
(incluyendo 8 y 14). Si el usuario ingresa una contraseña de longitud adecuada, imprimir por en 
pantalla el mensaje "Ha ingresado una contraseña correcta"; en caso contrario, imprimir por 
pantalla "Por favor, ingrese una contraseña de entre 8 y 14 caracteres". Nota: investigue el uso 
de la función len() en Python para evaluar la cantidad de elementos que tiene un iterable tal 
como una lista o un string.
"""

password = input("Ingrese una contraseña entre 8 y 14 caracteres: ")
validated_password = len(password)

if validated_password < 8 or validated_password > 14:
    print("Contraseña inválida, ingrese una contraseña entre 8 a 14 caracteres.")

if validated_password >= 8 and validated_password <= 14:
    print("Ha ingresado una contraseña correcta.")

"""
6) El paquete statistics de python contiene funciones que permiten tomar una lista de números 
y calcular la moda, la mediana y la media de dichos números. 

La moda (mode), la mediana (median) y la media (mean) son parámetros estadísticos que se 
pueden utilizar para predecir la forma de una distribución normal a partir del siguiente criterio: 
● Sesgo positivo o a la derecha: cuando la media es mayor que la mediana y, a su vez, la 
mediana es mayor que la moda. 
● Sesgo negativo o a la izquierda: cuando la media es menor que la mediana y, a su vez, 
la mediana es menor que la moda. 
● Sin sesgo: cuando la media, la mediana y la moda son iguales. 

Teniendo en cuenta lo antes mencionado, escribir un programa que tome la lista 
numeros_aleatorios, calcule su moda, su mediana y su media y las compare para determinar si 
hay sesgo positivo, negativo o no hay sesgo. Imprimir el resultado por pantalla. 
Definir la lista numeros_aleatorios de la siguiente forma: 
"""

import random
import statistics

numeros_aleatorios = [random.randint(1, 100) for i in range(50)]
print(numeros_aleatorios)

mode = statistics.mode(numeros_aleatorios)
median = statistics.median(numeros_aleatorios)
mean = statistics.mean(numeros_aleatorios)

print(f"Moda: {mode}")
print(f"Mediana: {median}")
print(f"Media: {mean}")

if mean > median and median > mode:
    print("Sesgo positivo (a la derecha).")

if mean < median and median < mode:
    print("Sesgo negativo (a la izquierda).")

if mean == median and median == mode:
    print("Sin sesgo.")

"""
7) Escribir un programa que solicite una frase o palabra al usuario. Si el string ingresado 
termina con vocal, añadir un signo de exclamación al final e imprimir el string resultante por 
pantalla; en caso contrario, dejar el string tal cual lo ingresó el usuario e imprimirlo por 
pantalla. 
"""

frase = input("Ingrese una frase o palabra: ")

if frase.lower().endswith(("a", "e", "i", "o", "u")):
    frase += "!"

print(frase)

"""
8) Escribir un programa que solicite al usuario que ingrese su nombre y el número 1, 2 o 3 
dependiendo de la opción que desee: 
1. Si quiere su nombre en mayúsculas. Por ejemplo: PEDRO. 
2. Si quiere su nombre en minúsculas. Por ejemplo: pedro. 
3. Si quiere su nombre con la primera letra mayúscula. Por ejemplo: Pedro. 
El programa debe transformar el nombre ingresado de acuerdo a la opción seleccionada por el 
usuario e imprimir el resultado por pantalla. Nota: investigue uso de las funciones upper(), 
lower() y title() de Python para convertir entre mayúsculas y minúsculas.
"""

nombre = input("Ingrese su nombre: ")

if not nombre.isalpha():
    print("Error: El nombre no debe contener números ni caracteres especiales.")

if nombre.isalpha():
    opcion = input(
        "Ingrese una opción:\n"
        "1 - Mayúsculas\n"
        "2 - Minúsculas\n"
        "3 - Primera letra en mayúscula\n"
        "Opción: "
    )

    if opcion == "1":
        nombre = nombre.upper()

    if opcion == "2":
        nombre = nombre.lower()

    if opcion == "3":
        nombre = nombre.title()

    print(nombre)

"""
9) Escribir un programa que pida al usuario la magnitud de un terremoto, clasifique la 
magnitud en una de las siguientes categorías según la escala de Richter e imprima el resultado 
por pantalla: 
● Menor que 3: "Muy leve" (imperceptible). 
● Mayor o igual que 3  y menor que 4: "Leve" (ligeramente perceptible). 
● Mayor o igual que 4  y menor que 5: "Moderado" (sentido por personas, pero 
generalmente no causa daños). 
● Mayor o igual que 5  y menor que 6: "Fuerte" (puede causar daños en estructuras 
débiles). 
● Mayor o igual que 6  y menor que 7: "Muy Fuerte" (puede causar daños significativos). 
● Mayor o igual que 7: "Extremo" (puede causar graves daños a gran escala). 
"""

magnitud = int(input("Ingrese la magnitud del terremoto: "))

if magnitud < 0:
  print("No hay peligro.")

if magnitud < 3: 
  print("Muy leve")

if magnitud >= 3 and magnitud < 4:
  print("Leve")

if magnitud >= 4 and magnitud < 5:
  print("Moderado")

if magnitud >= 5 and magnitud < 6:
  print("Fuerte")

if magnitud >= 6 and magnitud < 7:
  print("Muy fuerte")

if magnitud >= 7:
  print("Extremo")


"""
Escribir un programa que pregunte al usuario en cuál hemisferio se encuentra (N/S), qué mes 
del año es y qué día es. El programa deberá utilizar esa información para imprimir por pantalla 
si el usuario se encuentra en otoño, invierno, primavera o verano.
"""

hemisferio = input("¿En qué hemisferio te encuentras? (N/S): ").upper()
mes = int(input("¿Qué mes del año es? (1-12): "))
dia = int(input("¿Qué día del mes es? (1-31): "))

if hemisferio == 'N':
    if (mes == 12 and dia >= 21) or mes == 1 or mes == 2 or (mes == 3 and dia <= 20):
        estacion = "Invierno"
    if (mes == 3 and dia >= 21) or mes == 4 or mes == 5 or (mes == 6 and dia <= 20):
        estacion = "Primavera"
    if (mes == 6 and dia >= 21) or mes == 7 or mes == 8 or (mes == 9 and dia <= 20):
        estacion = "Verano"
    if (mes == 9 and dia >= 21) or mes == 10 or mes == 11 or (mes == 12 and dia <= 20):
        estacion = "Otoño"
    
if hemisferio == 'S':
    if (mes == 12 and dia >= 21) or mes == 1 or mes == 2 or (mes == 3 and dia <= 20):
        estacion = "Verano"
    if (mes == 3 and dia >= 21) or mes == 4 or mes == 5 or (mes == 6 and dia <= 20):
        estacion = "Otoño"
    if (mes == 6 and dia >= 21) or mes == 7 or mes == 8 or (mes == 9 and dia <= 20):
        estacion = "Invierno"
    if (mes == 9 and dia >= 21) or mes == 10 or mes == 11 or (mes == 12 and dia <= 20):
        estacion = "Primavera"

print(f"La estación en tu hemisferio es: {estacion}")
