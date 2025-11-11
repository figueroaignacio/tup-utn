use gestionacademica;

-- vista basica de alumnos
create or replace view vista_alumnos_basica as select id, nombre, apellido from alumnos;
select * from vista_alumnos_basica;

-- consulta mixta entre vista y tabla
select v.nombre, v.apellido, c.nombre_carrera
from vista_alumnos_basica v
inner join alumnos a on v.id = a.id
inner join carreras c on a.id_carrera = c.id;

-- vista de asignaturas por carrera
create or replace view vista_asignaturas_carrera as 
select a.nombre as asignatura,
       a.creditos,
       c.nombre_carrera
from asignaturas a 
inner join carreras c on a.id_carrera = c.id;
select * from vista_asignaturas_carrera;

-- vista de asignaturas por creditos altos
create or replace view vista_asignaturas_credito_alto as 
select nombre as asignatura, creditos
from asignaturas
where creditos > 5;

-- consulta mixta con vistas
select c.nombre_carrera, v.asignatura, v.creditos
from vista_asignaturas_credito_alto v
inner join asignaturas a on v.asignatura = a.nombre
inner join carreras c on a.id_carrera = c.id;

-- vista de créditos totales por alumno
create or replace view vista_creditos_por_alumno as 
select
  a.id,
  a.nombre,
  a.apellido,
  sum(asig.creditos) as total_creditos
from alumnos a
inner join asignaturas asig on a.id_carrera = asig.id_carrera
group by a.id, a.nombre, a.apellido;
select * from vista_creditos_por_alumno;

-- vista de alumnos mayores de 21 años
create or replace view vista_alumnos_mayores as
select nombre, apellido, edad, id_carrera
from alumnos
where edad > 21;
select * from vista_alumnos_mayores;

-- vista de asignaturas con más de 3 créditos
create or replace view vista_asignaturas_creditos as
select nombre as asignatura, creditos, id_carrera
from asignaturas
where creditos > 3;
select * from vista_asignaturas_creditos;

-- consulta mixta entre vistas
select
  a.nombre,
  a.apellido,
  a.edad,
  c.nombre_carrera,
  asig.asignatura,
  asig.creditos
from alumnos a
inner join carreras c on a.id_carrera = c.id
inner join vista_asignaturas_creditos asig on c.id = asig.id_carrera;

-- actualizar vista_alumnos_basica para incluir edad
create or replace view vista_alumnos_basica as
select id, nombre, apellido, edad
from alumnos;
select * from vista_alumnos_basica;

-- actualizar vista vista_asignaturas_credito_alto para incluir el nombre de la carrera
create or replace view vista_asignaturas_credito_alto as
select a.nombre as asignatura, a.creditos, c.nombre_carrera
from asignaturas a
inner join carreras c on a.id_carrera = c.id
where a.creditos > 5;
select * from vista_asignaturas_credito_alto;

-- actualizar vista vista_asignaturas_carrera para mostrar solo asignaturas con más de 3 créditos
create or replace view vista_asignaturas_carrera as
select a.nombre as asignatura, a.creditos, c.nombre_carrera
from asignaturas a
inner join carreras c on a.id_carrera = c.id
where a.creditos > 3;
select * from vista_asignaturas_carrera;

-- actualizar vista vista_alumnos_mayores para incluir el nombre de la carrera
create or replace view vista_alumnos_mayores as
select a.nombre, a.apellido, a.edad, c.nombre_carrera
from alumnos a
inner join carreras c on a.id_carrera = c.id
where a.edad > 21;
select * from vista_alumnos_mayores;

-- actualizar vista vista_creditos_por_alumno para incluir el nombre de la carrera
create or replace view vista_creditos_por_alumno as
select
  a.id,
  a.nombre,
  a.apellido,
  c.nombre_carrera,
  SUM(asig.creditos) as total_creditos
from alumnos a
inner join carreras c on a.id_carrera = c.id
inner join asignaturas asig on a.id_carrera = asig.id_carrera
group by a.id, a.nombre, a.apellido, c.nombre_carrera;
select * from vista_creditos_por_alumno;


