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