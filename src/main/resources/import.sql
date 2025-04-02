-- Insertar personas de ejemplo al inicializar la base de datos
INSERT INTO persona (nombre, edad) VALUES ('Juan', 30);
INSERT INTO persona (nombre, edad) VALUES ('Maria', 25);
INSERT INTO persona (nombre, edad) VALUES ('Carlos', 40);
INSERT INTO persona (nombre, edad) VALUES ('Ana', 22);

-- Insertar autos de ejemplo asociados con las personas
INSERT INTO auto (marca, modelo, persona_id) VALUES ('Toyota', 'Corolla', 1);
INSERT INTO auto (marca, modelo, persona_id) VALUES ('Honda', 'Civic', 2);
INSERT INTO auto (marca, modelo, persona_id) VALUES ('Ford', 'Focus', 3);
INSERT INTO auto (marca, modelo, persona_id) VALUES ('Chevrolet', 'Cruze', 4);

-- Insertar perros de ejemplo
INSERT INTO perro (nombre, raza) VALUES ('Rex', 'Labrador');
INSERT INTO perro (nombre, raza) VALUES ('Toby', 'Bulldog');
INSERT INTO perro (nombre, raza) VALUES ('Max', 'Beagle');
INSERT INTO perro (nombre, raza) VALUES ('Bella', 'Pastor Alemán');

-- Insertar asociaciones entre personas y perros
INSERT INTO persona_perro (persona_id, perro_id) VALUES (1, 1); -- Juan tiene a Rex
INSERT INTO persona_perro (persona_id, perro_id) VALUES (2, 2); -- Maria tiene a Toby
INSERT INTO persona_perro (persona_id, perro_id) VALUES (3, 3); -- Carlos tiene a Max
INSERT INTO persona_perro (persona_id, perro_id) VALUES (4, 4); -- Ana tiene a Bella