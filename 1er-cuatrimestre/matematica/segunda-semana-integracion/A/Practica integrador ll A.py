#A. Operaciones con DNIs
#Ingreso de los DNIs (reales o ficticios).

dniA = 46582392
dniB = 43524123
dniC = 41906566
dniD = 45406120

#Generación automática de los conjuntos de dígitos únicos.

digitos_dniA = set(map(int, str(dniA)))  
digitos_dniB = set(map(int, str(dniB)))  
digitos_dniC = set(map(int, str(dniC)))  
digitos_dniD = set(map(int, str(dniD)))  

print("DNI A:", dniA, "->", digitos_dniA)
print("DNI B:", dniB, "->", digitos_dniB)
print("DNI C:", dniC, "->", digitos_dniC)
print("DNI D:", dniD, "->", digitos_dniD)
print('')

#Cálculo y visualización de: unión, intersección, diferencias y diferencia simétrica.

print("Union DNI A-B:", digitos_dniA.union(digitos_dniB))
print("Union DNI A-C:", digitos_dniA.union(digitos_dniC))
print("Union DNI C-B:", digitos_dniC.union(digitos_dniB))
print("Union DNI A-D:", digitos_dniA.union(digitos_dniD))
print("Union DNI B-D:", digitos_dniB.union(digitos_dniD))
print("Union DNI C-D:", digitos_dniC.union(digitos_dniD))
print('')

print("Interseccion DNI A-B:", digitos_dniA.intersection(digitos_dniB))
print("Interseccion DNI A-C:", digitos_dniA.intersection(digitos_dniC))
print("Interseccion DNI C-B:", digitos_dniC.intersection(digitos_dniB))
print("Interseccion DNI A-C:", digitos_dniA.intersection(digitos_dniC))
print("Interseccion DNI B-C:", digitos_dniB.intersection(digitos_dniC))
print("Interseccion DNI D-C:", digitos_dniD.intersection(digitos_dniC))
print('')

print("Diferencia DNI A-B:", digitos_dniA.difference(digitos_dniB))
print("Diferencia DNI A-C:", digitos_dniA.difference(digitos_dniC))
print("Diferencia DNI A-D:", digitos_dniA.difference(digitos_dniD))
print("Diferencia DNI B-C:", digitos_dniB.difference(digitos_dniC))
print("Diferencia DNI B-A:", digitos_dniB.difference(digitos_dniA))
print("Diferencia DNI B-D:", digitos_dniB.difference(digitos_dniD))
print("Diferencia DNI C-B:", digitos_dniC.difference(digitos_dniB))
print("Diferencia DNI C-A:", digitos_dniC.difference(digitos_dniA))
print("Diferencia DNI C-D:", digitos_dniC.difference(digitos_dniD))
print("Diferencia DNI D-A:", digitos_dniD.difference(digitos_dniA))
print("Diferencia DNI D-B:", digitos_dniD.difference(digitos_dniB))
print("Diferencia DNI D-C:", digitos_dniD.difference(digitos_dniC))
print('')

diferencia_simetricaAB = digitos_dniA ^ digitos_dniB
diferencia_simetricaAC = digitos_dniA ^ digitos_dniC
diferencia_simetricaCB = digitos_dniC ^ digitos_dniB
diferencia_simetricaDA = digitos_dniD ^ digitos_dniA
diferencia_simetricaDB = digitos_dniD ^ digitos_dniB
diferencia_simetricaDC = digitos_dniD ^ digitos_dniC

print("Diferencia simétrica A-B:", diferencia_simetricaAB)
print("Diferencia simétrica A-C:", diferencia_simetricaAC)
print("Diferencia simétrica C-B:", diferencia_simetricaCB)
print("Diferencia simétrica D-A:", diferencia_simetricaDA)
print("Diferencia simétrica D-B:", diferencia_simetricaDB)
print("Diferencia simétrica D-C:", diferencia_simetricaDC)
print('')


#Conteo de frecuencia de cada dígito en cada DNI utilizando estructuras repetitivas.
frecuencia_dniA = {}
frecuencia_dniB = {}
frecuencia_dniC = {}
frecuencia_dniD = {}

for digito in str(dniA):
    d = int(digito)
    if d in frecuencia_dniA:
        frecuencia_dniA[d] += 1
    else:
        frecuencia_dniA[d] = 1

for digito in str(dniB):
    d = int(digito)
    if d in frecuencia_dniB:
        frecuencia_dniB[d] += 1
    else:
        frecuencia_dniB[d] = 1

for digito in str(dniC):
    d = int(digito)
    if d in frecuencia_dniC:
        frecuencia_dniC[d] += 1
    else:
        frecuencia_dniC[d] = 1

for digito in str(dniD):
    d = int(digito)
    if d in frecuencia_dniD:
        frecuencia_dniD[d] += 1
    else:
        frecuencia_dniD[d] = 1

print("Frecuencia de dígitos en DNI A:", frecuencia_dniA)
print("Frecuencia de dígitos en DNI B:", frecuencia_dniB)
print("Frecuencia de dígitos en DNI C:", frecuencia_dniC)
print("Frecuencia de dígitos en DNI D:", frecuencia_dniD)
print('')

#Suma total de los dígitos de cada DNI.

suma_dniA = 0
suma_dniB = 0
suma_dniC = 0
suma_dniD = 0

for digito in str(dniA):
    suma_dniA += int(digito)

for digito in str(dniB):
    suma_dniB += int(digito)

for digito in str(dniC):
    suma_dniC += int(digito)

for digito in str(dniD):
    suma_dniD += int(digito)

print("Suma de los dígitos del DNI A:", suma_dniA)
print("Suma de los dígitos del DNI B:", suma_dniB)
print("Suma de los dígitos del DNI C:", suma_dniC)
print("Suma de los dígitos del DNI D:", suma_dniD)
print('')

#Evaluación de condiciones lógicas (condicionales), vinculadas con las expresiones escritas.

#Comparacion de la suna de digitos

if suma_dniA > suma_dniB and suma_dniA > suma_dniC and suma_dniA > suma_dniD:
    print("La suma de los dígitos del DNI A es mayor.")
elif suma_dniB > suma_dniA and suma_dniB > suma_dniC and suma_dniB > suma_dniD:
    print("La suma de los dígitos del DNI B es mayor.")
elif suma_dniC > suma_dniA and suma_dniC > suma_dniB and suma_dniC > suma_dniD:
    print("La suma de los dígitos del DNI C es mayor.")
elif suma_dniD > suma_dniA and suma_dniD > suma_dniB and suma_dniD > suma_dniC:
    print("La suma de los dígitos del DNI D es mayor.")
else:
    print("Hay al menos dos DNI con la suma de dígitos igual y mayor.")
print('')

#Interseccion total de digitos 

interseccion_total = digitos_dniA & digitos_dniB & digitos_dniC & digitos_dniD
if interseccion_total:
    print("Dígito/s compartido/s entre todos los DNIs:", interseccion_total)
else:
    print("No hay dígito compartido entre todos los DNIs.")
print('')

# Evaluar diversidad numérica basada en cantidad de dígitos distintos

def evaluar_diversidad(digitos_unicos, dni_num):
    cantidad = len(digitos_unicos)
    if cantidad >= 7:
        print(f"DNI {dni_num}: Diversidad numérica alta ({cantidad} dígitos distintos)")
    elif cantidad >= 5:
        print(f"DNI {dni_num}: Diversidad numérica media ({cantidad} dígitos distintos)")
    else:
        print(f"DNI {dni_num}: Diversidad numérica baja ({cantidad} dígitos distintos)")

# Evaluar cada DNI
evaluar_diversidad(digitos_dniA, 1)
evaluar_diversidad(digitos_dniB, 2)
evaluar_diversidad(digitos_dniC, 3)
evaluar_diversidad(digitos_dniD, 4)