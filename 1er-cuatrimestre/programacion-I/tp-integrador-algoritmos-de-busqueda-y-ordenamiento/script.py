# Función para ordenar una lista usando el algoritmo de inserción
def ordenamiento_insercion(lista):
    # Recorremos desde el segundo elemento hasta el final
    for i in range(1, len(lista)):
        clave = lista[i]          # Guardamos el elemento actual a insertar
        j = i - 1                 # Índice del elemento anterior
        # Movemos los elementos mayores que 'clave' una posición hacia adelante
        while j >= 0 and clave < lista[j]:
            lista[j + 1] = lista[j]
            j -= 1
        # Insertamos 'clave' en la posición correcta
        lista[j + 1] = clave
    return lista

# Función para buscar un elemento en la lista usando búsqueda lineal
def busqueda_lineal(lista, objetivo):
    # Recorremos todos los elementos uno por uno
    for i in range(len(lista)):
        if lista[i] == objetivo:
            return i      # Si encontramos el elemento, devolvemos su posición
    return -1             # Si no está, devolvemos -1

# Función para buscar un elemento usando búsqueda binaria
def busqueda_binaria(lista, objetivo):
    inicio, fin = 0, len(lista) - 1  # Definimos los extremos de la búsqueda
    while inicio <= fin:
        medio = (inicio + fin) // 2   # Calculamos el índice medio
        if lista[medio] == objetivo:
            return medio              # Encontramos el elemento, devolvemos posición
        elif lista[medio] < objetivo:
            inicio = medio + 1        # Buscamos en la mitad derecha
        else:
            fin = medio - 1           # Buscamos en la mitad izquierda
    return -1                        # Si no se encuentra, devolvemos -1

# Prueba de los algoritmos
datos = [42, 7, 13, 29, 18]                  # Lista original desordenada
ordenada = ordenamiento_insercion(datos.copy())  # Ordenamos la lista usando inserción
print("Lista ordenada:", ordenada)            # Mostramos la lista ordenada
print("Lineal (29):", busqueda_lineal(ordenada, 29))  # Buscamos 29 con búsqueda lineal
print("Binaria (29):", busqueda_binaria(ordenada, 29)) # Buscamos 29 con búsqueda binaria
