"""
1 - Crear una lista con los numeros del 1 al 100 que sean multiplos de 4. Utilizar la funcion range.
"""

numeros = list(range(4, 101, 4))
print(numeros)


"""
2 - Crear una lista con cinco elementos (colocar los elementos que más te gusten) y mostrar el 
penúltimo.
"""

lista = ["Radix", "shadcn", "MUI", "Tailwind", "Chakra"]
print(lista[3])

"""
3 - Crear una lista vacía, agregar tres palabras con append e imprimir la lista resultante por 
pantalla. Pista: para crear una lista vacía debes colocar los corchetes sin nada en su interior,
"""

lista_vacia = []

lista_vacia.append("manzana")
lista_vacia.append("banana")
lista_vacia.append("naranja")

print(lista_vacia)

"""
4 - Reemplazar el segundo y último valor de la lista “animales” con las palabras “loro” y “oso”, 
respectivamente.  Imprimir la lista resultante por pantalla. ¡Puedes hacerlo como se muestra 
en los videos o bien investigar cómo funciona el indexing con números negativos!
"""

animales = ["perro", "gato", "conejo", "pez"] 

animales[1] = "loro"
animales[3] = "oso"

print(animales)

"""
5 - Analizar el siguiente programa y explicar con tus palabras qué es lo que realiza. 
"""

# El siguiente codigo lo que hace es eliminar el valor mas grande del array de los numeros. En este caso elimina el numero 22 del array.

numeros = [6, 15, 3, 22, 7]
numeros.remove(max(numeros))
print(numeros)

"""
6 - Crear una lista con números del 10 al 30 (incluído), haciendo saltos de 5 en 5 y mostrar por 
pantalla los dos primeros.
"""

numeros = list(range(10, 31, 5))
print(numeros[:2])

"""
7 - Reemplazar los dos valores centrales (índices 1 y 2) de la lista “autos” por dos nuevos valores 
cuales quiera. 
"""

autos = ["sedan", "polo", "suran", "gol"] 

autos[1] = "prisma"
autos[2] = "corola"

print(autos)

"""
8 - Crear una lista vacía llamada "dobles" y agregar el doble de 5, 10 y 15 usando append 
directamente. Imprimir la lista resultante por pantalla. 
"""

dobles = []

dobles.append(5 * 2)
dobles.append(10 * 2)
dobles.append(15 * 2)

print(dobles)

"""
9 -  Dada la lista “compras”, cuyos elementos representan los productos comprados por 
diferentes clientes: 
  a) Agregar "jugo" a la lista del tercer cliente usando append. 
  b) Reemplazar "fideos" por "tallarines" en la lista del segundo cliente. 
  c) Eliminar "pan" de la lista del primer cliente.  
  d) Imprimir la lista resultante por pantalla 
"""

compras = [["pan", "leche"], ["arroz", "fideos", "salsa"], ["agua"]] 

compras[2].append("jugo")
compras[1][1] = "tallarines"
compras[0].remove("pan")

print(compras)


"""
10 - Elaborar una lista anidada llamada “lista_anidada” que contenga los siguientes elementos: 
    ● Posición lista_anidada[0]: 15 
    ● Posición lista_anidada[1]: True 
    ● Posición lista_anidada[2][0]: 25.5 
    ● Posición lista_anidada[2][1]: 57.9 
    ● Posición lista_anidada[2][2]: 30.6 
    ● Posición lista_anidada[3]: False  
Imprimir la lista resultante por pantalla
"""

lista_anidada = []

lista_anidada.append(15)         
lista_anidada.append(True)       
lista_anidada.append([25.5, 57.9, 30.6])
lista_anidada.append(False)      

print(lista_anidada)