# Crear un programa que pida al usuario su nombre, apellido, edad y lugar de residencia e 
# imprima por pantalla una oración con los datos ingresados. Por ejemplo: si el usuario ingresa 
# “Marcos”, “Pérez”, “30” y “Argentina”, el programa debe imprimir “Soy Marcos Pérez, tengo 30 
# años y vivo en Argentina”. Consejo: esto será más sencillo si utilizas print(f…) para realizar 
# la impresión por pantalla. 

nombre = input("Ingrese su nombre completo: ")
edad = input("Ingrese su edad: ")  
residencia = input("Ingrese su lugar de residencia actual: ")

print(f"Soy {nombre}, tengo {edad} años y vivo en {residencia}.")
