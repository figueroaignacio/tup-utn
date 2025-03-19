# Crear un programa que pida al usuario su altura y su peso e imprima por pantalla su índice 
# de masa corporal.

peso = float(input("Ingrese su peso en kg: "))
altura = float(input("Ingrese su altura en metros: "))

imc = peso / (altura ** 2)

print(f"Tu Índice de Masa Corporal (IMC) es: {imc:.2f}")
