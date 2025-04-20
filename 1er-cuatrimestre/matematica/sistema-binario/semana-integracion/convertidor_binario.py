# Entrada usuario 
"""
Pide al usuario que ingrese un número decimal positivo.
int(input(...)) convierte esa entrada en un número entero.
"""
numero = int(input("Ingrese el número Decimal positivo del que quiera obtener el Binario \n Tu elección: "))

# Inicialización 
"""
Se crea una lista vacía donde se guardarán los restos (0 o 1) del número al dividir por 2.
"""
binario = []

# Conversión de decimal a binario
while numero != 0: # mientras el número sea distinto de 0, seguimos dividiendo
    resto = numero % 2 # se obtiene el resto de dividir el número por 2 (será 0 o 1).
    binario.append(str(resto)) # se guarda ese resto como string en la lista binario.
    numero = numero // 2  # se actualiza el número dividiéndolo por 2 (división entera).
    binario_definitivo = "".join(binario[::-1]) # se invierte la lista, porque el primer resto corresponde al bit menos significativo y convierte la lista de strings en un solo string que representa el binario final.

# Impresión del resultado
print("El número en binario es:", binario_definitivo)
