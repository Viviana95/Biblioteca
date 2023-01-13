use biblioteca;
select * from libros;
#----------------------------------Lectores---------------------------------------
INSERT INTO lectores (nombre, telefono, direccion) 
VALUES ('Paco Fernández', '987987987','Oviedo' );
INSERT INTO lectores (nombre, telefono, direccion) 
VALUES ('Sara Pérez', '876554332','Avilés' );
INSERT INTO lectores (nombre, telefono, direccion) 
VALUES ('Lola Miguelañez', '467467895','Gijón' );
INSERT INTO lectores (nombre, telefono, direccion) 
VALUES ('Raúl Arias', '675987358','La Felguera' );
INSERT INTO lectores (nombre, telefono, direccion) 
VALUES ('Eustaquio ', '888888888','Gijón' );
select * from lectores;
#---------------------------------Libros----------------------------------------------------------------
INSERT INTO libros (isbn, anyo, editorial, nacimiento_autor, nacionalidad_autor, nombre_autor, tipo, titulo) 
VALUES ('123456', '1990', 'Lumen' , '1970-12-3', 'Española', 'Raúl Gómez', 1, 'Las rosas de invierno');
INSERT INTO libros (isbn, anyo, editorial, nacimiento_autor, nacionalidad_autor, nombre_autor, tipo, titulo) 
VALUES ('13578936', '2001', 'Tusquets' , '1926-03-05', 'Cubana', 'Laura Vilas', 2, 'Ensayo de naturaleza');
INSERT INTO libros (isbn, anyo, editorial, nacimiento_autor, nacionalidad_autor, nombre_autor, tipo, titulo) 
VALUES ('36839476', '1928', 'Anaya' , '1870-11-11', 'Venezolana', 'Samuel Pérez', 3, 'Los amores de Carmina');
INSERT INTO libros (isbn, anyo, editorial, nacimiento_autor, nacionalidad_autor, nombre_autor, tipo, titulo) 
VALUES ('48420384', '1703', 'Cátedra' , '1614-02-07', 'Argentina', 'Mario Antretti', 1, 'Amaneceres');
INSERT INTO libros (isbn, anyo, editorial, nacimiento_autor, nacionalidad_autor, nombre_autor, tipo, titulo) 
VALUES ('48482598', '1690', 'Alfaguara' , '1550-07-12', 'Argentina', 'Lolo Zapico', '2', 'Soledad');
INSERT INTO libros (isbn, anyo, editorial, nacimiento_autor, nacionalidad_autor, nombre_autor, tipo, titulo) 
VALUES ('485420444', '2010', 'SM' , '1872-06-17', 'Francesa', 'François Joubert', '0', 'Les garçons au matin');
INSERT INTO libros (isbn, anyo, editorial, nacimiento_autor, nacionalidad_autor, nombre_autor, tipo, titulo) 
VALUES ('5373836', '2007', 'Xeral' , '2000-10-02','Española', 'Xosé Ferreiro', '3', 'Os carballos pechos');
INSERT INTO libros (isbn, anyo, editorial, nacimiento_autor, nacionalidad_autor, nombre_autor, tipo, titulo) 
VALUES ('34783939', '1980', 'Planeta' , '1987-04-26', 'Escocesa', 'John McMillan', '1', 'Troubled times');
INSERT INTO libros (isbn, anyo, editorial, nacimiento_autor, nacionalidad_autor, nombre_autor, tipo, titulo) 
VALUES ('8352392', '1965', 'SM' , '1953-07-21', 'Italiana', 'Carolina Lanotte', '2', 'Il bel canto');
INSERT INTO libros (isbn, anyo, editorial, nacimiento_autor, nacionalidad_autor, nombre_autor, tipo, titulo) 
VALUES ('27383947', '1995', 'Anaya' , '1782-03-01', 'Portuguesa', 'Isaura Coelho', '3', 'Bom dia, amor');
select * from libros;
#-------------------------------------------Copias----------------------------------------------------------
INSERT INTO copias (estado, isbn) 
VALUES (0, '123456' );
INSERT INTO copias (estado, isbn) 
VALUES (1, '123456' );
INSERT INTO copias (estado, isbn) 
VALUES (2, '13578936' );
INSERT INTO copias (estado, isbn) 
VALUES (3, '13578936' );
INSERT INTO copias (estado, isbn) 
VALUES (2, '34783939' );
INSERT INTO copias (estado, isbn) 
VALUES (1, '48420384' );
INSERT INTO copias (estado, isbn) 
VALUES (1, '48420384' );
select * from copias;
#----------------------------------Prestamos---------------------------------------
INSERT INTO prestamos (inicio, fin, id_copia, n_socio) 
VALUES ('2023-01-01', '2023-01-30', 1, 1);
INSERT INTO prestamos (inicio, fin, id_copia, n_socio) 
VALUES ('2023-01-01', '2023-01-30', 2, 1);
INSERT INTO prestamos (inicio, fin, id_copia, n_socio) 
VALUES ('2023-01-01', '2023-01-30', 3, 1);
INSERT INTO prestamos (inicio, fin, id_copia, n_socio) 
VALUES ('2023-01-01', '2023-01-30', 4, 2);
INSERT INTO prestamos (inicio, fin, id_copia, n_socio) 
VALUES ('2023-01-01', '2023-01-30', 5, 3);
INSERT INTO prestamos (inicio, fin, id_copia, n_socio) 
VALUES ('2023-01-01', '2023-01-30', 6, 4);
select * from prestamos;