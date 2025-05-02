#!/bin/bash

# Grupo 1

# Ejercicio 1.1
saludo="Y si, es nuestro primer programa."
echo $saludo

# Ejercicio 1.2
ls -l

# Ejercicio 1.3

mkdir backup
cp *.txt backup/
echo "Archivos .txt copiados a 'backup'."

# Grupo 2: Variables y operadores aritméticos

# Ejercicio 2.1

x=10
y=5

suma=$((x + y))
echo "La suma de $x y $y es: $suma"

resta=$((x - y))
echo "La resta de $x y $y es: $resta"

multiplicacion=$((x * y))
echo "La multiplicación de $x y $y es: $multiplicacion"

division=$((x / y))
echo "La división de $x y $y es: $division"


# Ejercicio 2.2

base=8
altura=5

area=$((base * altura))

echo "El área del rectángulo es: $area"

# Ejercicio 2.3

nombre="Nacho"
edad="21"
ciudad="Buenos Aires"

echo "Hola, mi nombre es $nombre, tengo $edad años y vivo en $ciudad."

# Grupo 3: Condicionales

# Ejercicio 3.1

echo -n "Ingrese su edad: "
read edad

if [ $edad -ge 18 ]; then
  echo "Eres mayor de edad."
else
  echo "Eres menor de edad."
fi

# Ejercicio 3.2

echo -n "Ingrese el nombre del archivo: "
read archivo

if [ -f "$archivo" ]; then
  echo "El archivo $archivo existe."
else
  echo "El archivo $archivo no existe."
fi

# Ejercicio 3.3

echo -n "Ingresá la nota (0 a 10): "
read nota

if [ "$nota" -lt 6 ]; then
  echo "Reprobado"
elif [ "$nota" -ge 6 ] && [ "$nota" -le 8 ]; then
  echo "Aprobado"
elif [ "$nota" -ge 9 ] && [ "$nota" -le 10 ]; then
  echo "Excelente"
else
  echo "Nota inválida"
fi

# Grupo 4: Bucles

# Ejercicio 4.1

for i in {1..10}
do
  echo "$i"
done

# Ejercicio 4.2

suma=0
i=1

while [ $i -le 100 ]
do
  suma=$((suma + i))   
  i=$((i + 1))        
done

echo "La suma de los números del 1 al 100 es: $suma"

# Ejercicio 4.3

until [ "$contrasena" == "secreto" ]
do
  read -sp "Ingrese la contraseña: " contrasena
  echo

  if [ "$contrasena" != "secreto" ]; then
    echo "Contraseña incorrecta, intente nuevamente."
  fi
done

echo "Contraseña correcta. Acceso concedido."

# Grupo 5: Entrada del usuario

# Ejercicio 5.1

echo -n "Ingrese su nombre: "
read nombre

echo -n "Ingrese su apellido: "
read apellido

nombre_mayuscula=$(echo "$nombre" | tr "a-z" "A-Z")
apellido_mayuscula=$(echo "$apellido" | tr "a-z" "A-Z")

echo "Nombre completo en mayúsculas: $nombre_mayuscula $apellido_mayuscula"

# Ejercicio 5.2

echo "Ingrese una palabra: "
read palabra

longitud=${#palabra}

echo "La longitud de la palabra $palabra es: $longitud"

# Ejercicio 5.3

echo "Por favor, ingrese su contraseña:"
read -s contrasena

echo
echo "Contraseña ingresada correctamente."

# Grupo 6: Manipulación de cadenas

# Ejercicio 6.1

echo "Por favor, ingrese una cadena:"
read cadena

primeros_8=${cadena:0:8}

echo "Los primeros 8 caracteres son: $primeros_8"

# Ejercicio 6.2

cadena="Hubo un error al procesar el error en el sistema."

cadena_modificada=${cadena//error/problemita}

echo "Cadena original: $cadena"
echo "Cadena modificada: $cadena_modificada"

# Ejercicio 6.3

echo "Por favor, ingresa un texto:"
read texto

texto_minusculas=$(echo "$texto" | tr '[:upper:]' '[:lower:]')

echo "Texto en minúsculas: $texto_minusculas"

# Grupo 7: Scripts combinando conceptos

# Ejercicio 7.1

echo "Por favor, ingresa tu nombre:"
read nombre

echo "Por favor, ingresa tu edad:"
read edad

if [ $edad -ge 16 ]; then
  echo "$nombre, puedes votar."
else
  echo "$nombre, no puedes votar."
fi

# Ejercicio 7.2

if [ ! -f nombres.txt ]; then
  echo "El archivo 'nombres.txt' no existe."
  exit 1
fi

while IFS= read -r nombre; do
  echo "¡Hola, $nombre!"
done < nombres.txt

# Ejercicio 7.3

suma=0

echo "Por favor, ingresa 5 números para calcular el promedio:"

for i in {1..5}
do
  echo "Ingresa el número $i:"
  read numero
  suma=$((suma + numero))  
done

promedio=$((suma / 5))

echo "El promedio de los 5 números es: $promedio"
