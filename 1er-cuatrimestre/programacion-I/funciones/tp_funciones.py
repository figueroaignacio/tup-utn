"""
1 - Crear una función llamada imprimir_hola_mundo que imprima por
    pantalla el mensaje: “Hola Mundo!”. Llamar a esta función desde el
    programa principal.
"""

def imprimir_hola_mundo():
    print("Hola mundo!")

imprimir_hola_mundo()

"""
2 - Crear una función llamada saludar_usuario(nombre) que reciba
    como parámetro un nombre y devuelva un saludo personalizado.
    Por ejemplo, si se llama con saludar_usuario("Marcos"), deberá de
    volver: “Hola Marcos!”. Llamar a esta función desde el programa
    principal solicitando el nombre al usuario.
"""

def saludar_usuario(nombre):
    print(f"Hola, {nombre}")

saludar_usuario("Nacho")

"""
3 - Crear una función llamada informacion_personal(nombre, apellido,
    edad, residencia) que reciba cuatro parámetros e imprima: “Soy
    [nombre] [apellido], tengo [edad] años y vivo en [residencia]”. Pe
    dir los datos al usuario y llamar a esta función con los valores in
    gresados.
"""

def informacion_personal(nombre, apellido, edad, residencia):
    print(f"Soy {nombre} {apellido}, tengo {edad} años, y vivo en {residencia}")

informacion_personal("Ignacio", "Figueroa", 21 , "Provincia de Buenos Aires, Argentina.")

"""
4 - Crear dos funciones: calcular_area_circulo(radio) que reciba el radio
    como parámetro y devuelva el área del círculo. calcular_peri
    metro_circulo(radio) que reciba el radio como parámetro y devuelva 
    el perímetro del círculo. Solicitar el radio al usuario y llamar ambas
    funciones para mostrar los resultados.
"""

import math

def calcular_area_circulo(radio): 
    area = math.pi * radio ** 2
    return area

def calcular_perimetro_circulo(radio): 
    perimetro = 2 * math.pi * radio
    return perimetro

def main():
    radio = float(input("Ingrese el radio del circulo: "))
    area = calcular_area_circulo(radio)
    perimetro = calcular_perimetro_circulo(radio)

    print(f"El área del circulo es: {area:.2f}")
    print(f"El perimetro del circulo es: {perimetro:.2f}")

if __name__ == "__main__":
    main()

"""
5 - Crear una función llamada segundos_a_horas(segundos) que reciba
    una cantidad de segundos como parámetro y devuelva la cantidad
    de horas correspondientes. Solicitar al usuario los segundos y mostrar
    el resultado usando esta función.
"""

def segundos_a_horas(segundos):
    horas = segundos / 3600
    return horas

def main():
    segundos = int(input("Ingrese la cantidad de segundos: "))
    horas = segundos_a_horas(segundos)
    print(f"{segundos} segundos equivalen a {horas:.2f} horas.")

if __name__ == "__main__":
    main()

"""
6 - Crear una función llamada tabla_multiplicar(numero) que reciba un
    número como parámetro y imprima la tabla de multiplicar de ese
    número del 1 al 10. Pedir al usuario el número y llamar a la función. 
"""

def tabla_multiplicar(numero):
    print(f"Tabla del {numero}")

  for i in range(11):
      resultado = numero * i
      print(f"{numero} x {i} = {resultado}")

def main(): 
    numero = int(input("Ingrese un numero para ver su tabla de multiplicar: "))
    tabla_multiplicar(numero)

if __name__ == "__main__":
    main()

"""
7 - Crear una función llamada operaciones_basicas(a, b) que reciba
    dos números como parámetros y devuelva una tupla con el resultado 
    de sumarlos, restarlos, multiplicarlos y dividirlos. Mostrar los 
    resultados de forma clara.
"""

def operaciones_basicas(a, b):
    suma = a + b
    resta = a - b
    multiplicacion = a * b
    division = a / b

    return suma, resta, multiplicacion, division

def main():
    a = float(input("Ingrese el primer número: "))
    b = float(input("Ingrese el segundo número: "))

    resultados = operaciones_basicas(a, b)

    print("\nResultados de las operaciones básicas:")
    print(f"Suma: {resultados[0]}")
    print(f"Resta: {resultados[1]}")
    print(f"Multiplicación: {resultados[2]}")
    print(f"División: {resultados[3]}")

if __name__ == "__main__":
    main()

"""
8 - Crear una función llamada calcular_imc(peso, altura) que reciba el
    peso en kilogramos y la altura en metros, y devuelva el índice de
    masa corporal (IMC). Solicitar al usuario los datos y llamar a la función
    para mostrar el resultado con dos decimales.
"""

def calcular_imc(peso, altura):
    calculo = peso / (altura ** 2)
    return calculo

def main():
    peso = float(input("Ingrese su peso en kilogramos (kg): "))
    altura = float(input("Ingrese su altura en metros (m): "))

    imc = calcular_imc(peso, altura)
    print(f"Su IMC es: {imc:.2f}")

    if imc < 18.5:
        print("Bajo peso")
    if imc >= 18.5 and imc < 25:
        print("Peso normal")
    if imc >= 25 and imc < 30:
        print("Sobrepeso")
    if imc >= 30:
        print("Obesidad")

if __name__ == "__main__":
   main()

"""
9 - Crear una función llamada celsius_a_fahrenheit(celsius) que reciba
    una temperatura en grados Celsius y devuelva su equivalente en
    Fahrenheit. Pedir al usuario la temperatura en Celsius y mostrar el
    resultado usando la función
"""

def celsius_a_farenheit(celsius):
    fahrenheit = (celsius * 9 / 5) + 32
    return fahrenheit

def main():
    celsius = float(input("Ingrese la temperatura en grados Celsius: "))
    fahrenheit = celsius_a_farenheit(celsius)
    print(f"{celsius}°C equivalen a {fahrenheit:.2f}°F")

if __name__ == "__main__":
    main()

"""
10 - Crear una función llamada calcular_promedio(a, b, c) que reciba
     tres números como parámetros y devuelva el promedio de ellos.
     Solicitar los números al usuario y mostrar el resultado usando esta
     función.
"""

def calcular_promedio(a, b, c):
    suma_total = a + b + c
    promedio = suma_total / 3

    return promedio

def main():
    a = float(input("Ingrese su primer nota: "))
    b = float(input("Ingrese su segunda nota: "))
    c = float(input("Ingrese su tercer nota: "))

    promedio_final = calcular_promedio(a, b, c)

    print(f"Su promedio final es: {promedio_final}")

if __name__ == "__main__":
    main()


