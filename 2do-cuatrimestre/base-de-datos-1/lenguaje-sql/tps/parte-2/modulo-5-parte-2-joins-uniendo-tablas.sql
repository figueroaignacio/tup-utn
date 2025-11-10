use gestionacademica;

-- mostrar el nombre completo del alumno y la duración de su carrera.
select concat(alumnos.nombre, " ", alumnos.apellido) as nombre_completo, 
carreras.duracion 
from alumnos
inner join carreras on  alumnos.id_carrera = carreras.id;

-- listar alumnos que pertenecen a carreras del departamento ‘Exactas’.
select alumnos.nombre, alumnos.apellido, carreras.nombre_carrera, carreras.departamento
from alumnos
inner join carreras on alumnos.id_carrera = carreras.id
where carreras.departamento = "Exactas";

-- left join
SELECT alumnos.nombre, carreras.nombre_carrera
FROM alumnos
LEFT JOIN carreras ON alumnos.id_carrera = carreras.id;

-- mostrar todos los alumnos junto con el nombre y duración de su carrera (si la tienen).
SELECT alumnos.nombre, alumnos.apellido,
       carreras.nombre_carrera, carreras.duracion
FROM alumnos
LEFT JOIN carreras ON alumnos.id_carrera = carreras.id;

-- mostrar los nombres de alumnos y el departamento de su carrera, incluyendo los que no tienen carrera.
SELECT alumnos.nombre, alumnos.apellido, carreras.departamento
FROM alumnos
LEFT JOIN carreras ON alumnos.id_carrera = carreras.id;

-- mostrar todas las carreras y el nombre de sus alumnos (si lo tienen)
SELECT carreras.nombre_carrera, alumnos.nombre, alumnos.apellido
FROM alumnos
RIGHT JOIN carreras ON alumnos.id_carrera = carreras.id;

-- mostrar todas las carreras junto con el departamento y los apellidos de los alumnos (si hay)
SELECT carreras.nombre_carrera, carreras.departamento, alumnos.apellido
FROM alumnos
RIGHT JOIN carreras ON alumnos.id_carrera = carreras.id;



