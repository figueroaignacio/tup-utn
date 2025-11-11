-- 1
select nombre, apellido
from alumnos
where edad < (select avg(edad) from alumnos);

-- 2
select id, nombre_carrera
from carreras
where id not in (select id_carrera from asignaturas);

-- 3
select departamento, sum(duracion) as total_duracion
from carreras
group by departamento;

-- 4
select nombre_carrera,
       (select COUNT(*) from alumnos where alumnos.id_carrera = carreras.id) as cantidad_alumnos
from carreras;

-- 5
select departamento,
       COUNT(id) as cantidad_carreras
from carreras
group by departamento;

-- 6
select a.nombre, a.apellido
from alumnos a
where (
  select SUM(asig.creditos)
  from asignaturas asig
  where asig.id_carrera = a.id_carrera
) > 10;

-- 7
select nombre, apellido
from alumnos
where id_carrera not in (
  select id
  from carreras
  where departamento = 'ARTES Y DISEÑO'
);

-- 8 
select nombre
from asignaturas
where id_carrera in (
  select id_carrera
  from alumnos
  where edad = (select min(edad) from alumnos)
);