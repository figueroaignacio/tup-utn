from datetime import datetime       # Modulo para obtener el año actual
from itertools import product       # Modulo para hacer el producto cartesiano

# Pedimos cuántos integrantes hay en el grupo
integrantes = int(input("¿Cuántos integrantes hay en el grupo? "))

# Obtenemos el año actual automáticamente
año_actual = datetime.now().year

# Creamos una lista vacía para guardar los años de nacimiento
años = []

# Ingresamos los años de nacimiento uno por uno
for i in range(integrantes):
    año = int(input(f"Ingresá el año de nacimiento del integrante {i + 1}: "))
    años.append(año)  # Agregamos el año a la lista

# Inicializamos contadores para años pares e impares
pares = 0
impares = 0

# Recorremos la lista de años para contar pares e impares
for año in años:
    if año % 2 == 0:
        pares += 1
    else:
        impares += 1

# Mostramos la cantidad de años pares e impares
print(f"\nCantidad que nacieron en años pares: {pares}")
print(f"Cantidad que nacieron en años impares: {impares}")

# Verificamos si todos los integrantes nacieron después del año 2000
if all(año > 2000 for año in años):
    print("Grupo Z")  # Si todos nacieron después del 2000, mostramos esto

# Función para verificar si un año es bisiesto
def es_bisiesto(año):
    return (año % 4 == 0 and año % 100 != 0) or (año % 400 == 0)

# Verificamos si al menos un integrante nació en un año bisiesto
if any(es_bisiesto(año) for año in años):
    print("Tenemos un año especial")  # Si alguno es bisiesto, mostramos esto

# Calculamos las edades actuales restando cada año del actual
edades = [año_actual - año for año in años]

# Mostramos el producto cartesiano entre años de nacimiento y edades
print("\nProducto cartesiano entre años y edades:")
for par in product(años, edades):
    print(par)  # Muestra cada combinación posible (año, edad)
