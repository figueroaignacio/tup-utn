# Crear un programa que pida al usuario una temperatura en grados Celsius e imprima por 
# pantalla su equivalente en grados Fahrenheit. Tener en cuenta la siguiente equivalencia: 

celsius = float(input("Ingrese la temperatura en grados a celsius: "))

farenheit = (celsius * 9/5) + 32

print(f"{celsius}°C equivalen a {farenheit:.2f}°F")

