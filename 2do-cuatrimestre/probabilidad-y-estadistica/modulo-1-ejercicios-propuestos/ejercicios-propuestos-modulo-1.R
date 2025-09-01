# 1️⃣ Crear un vector con los nombres de 4 lenguajes de programación y mostrar el segundo.

lenguajes <- c("TypeScript", "Java", "C++", "Python")
print(lenguajes[2])

# 2️⃣ Crear una matriz de 2 filas y 3 columnas con números del 1 al 6.

matriz <- matrix(1:6, nrow = 2, ncol = 3)
print(matriz)

# 3️⃣ Crear un dataframe con las variables: nombre, edad y carrera (3 personas).

datos <- data.frame(
  nombre = c("Ignacio", "Miguel", "Mayra"),
  edad = c(21, 21, 18),
  carrera = c("Programación", "Agronomía", "Diseñadora")
)

print(datos)

# 4️⃣ Consultar el tipo de estructura de cada uno con class().

class(datos$nombre)   # Tipo de la columna nombre
class(datos$edad)     # Tipo de la columna edad
class(datos$carrera)  # Tipo de la columna carrera

