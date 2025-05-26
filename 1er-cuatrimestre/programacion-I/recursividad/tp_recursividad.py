# 1 - Factorial recursivo de un número

def factorial(n):
    if n == 0 or n == 1:
        return 1
    return n * factorial(n - 1)

numero = 5
print(f"\n1 - Factoriales del 1 al {numero}:")
for i in range(1, numero + 1):
    print(f"Factorial de {i} es {factorial(i)}")


# 2 - Serie de Fibonacci recursiva

def fibonacci(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1
    return fibonacci(n - 1) + fibonacci(n - 2)

posicion = 10
print(f"\n2 - Serie de Fibonacci hasta la posición {posicion}:")
for i in range(posicion + 1):
    print(f"Fibonacci({i}) = {fibonacci(i)}")


# 3 - Potencia recursiva

def potencia(base, exponente):
    if exponente == 0:
        return 1
    return base * potencia(base, exponente - 1)

print(f"\n3 - Potencia con recursión:")
print(f"10 elevado a la 3 es {potencia(10, 3)}")


# 4 - Conversión de decimal a binario

def decimal_a_binario(n):
    if n == 0:
        return "0"
    elif n == 1:
        return "1"
    return decimal_a_binario(n // 2) + str(n % 2)

numero = 13
print(f"\n4 - Binario de {numero} es {decimal_a_binario(numero)}")


# 5 - Palíndromo recursivo

def es_palindromo(palabra):
    if len(palabra) <= 1:
        return True
    if palabra[0] != palabra[-1]:
        return False
    return es_palindromo(palabra[1:-1])

print("\n5 - Verificación de palíndromos:")
print(f"'neuquen' → {es_palindromo('neuquen')}")
print(f"'python' → {es_palindromo('python')}")


# 6 - Suma de dígitos

def suma_digitos(n):
    if n < 10:
        return n
    return n % 10 + suma_digitos(n // 10)

print("\n6 - Suma de dígitos:")
print(f"1234 → {suma_digitos(1234)}")
print(f"9 → {suma_digitos(9)}")
print(f"305 → {suma_digitos(305)}")


# 7 - Contar bloques en una pirámide

def contar_bloques(n):
    if n == 1:
        return 1
    return n + contar_bloques(n - 1)

print("\n7 - Bloques necesarios para construir una pirámide:")
print(f"Nivel más bajo = 1 → {contar_bloques(1)} bloques")
print(f"Nivel más bajo = 2 → {contar_bloques(2)} bloques")
print(f"Nivel más bajo = 4 → {contar_bloques(4)} bloques")


# 8 - Contar apariciones de un dígito

def contar_digito(numero, digito):
    if numero == 0:
        return 0
    coincidencia = 1 if numero % 10 == digito else 0
    return coincidencia + contar_digito(numero // 10, digito)

print("\n8 - Conteo de dígitos en un número:")
print(f"12233421, dígito 2 → {contar_digito(12233421, 2)} veces")
print(f"5555, dígito 5 → {contar_digito(5555, 5)} veces")
print(f"123456, dígito 7 → {contar_digito(123456, 7)} veces")
