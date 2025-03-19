# Crear un programa que pida al usuario  3 números e imprima por pantalla el promedio de 
# dichos números. 

a = float(input("Ingrese el primer numero del promedio: "))
b = float(input("Ingrese el segunda numero del promedio: "))
c = float(input("Ingrese el tercera numero del promedio: "))

calculo = a + b + c 
promedio = calculo / 3

print(f"El promedio es : {promedio:.2f}")
