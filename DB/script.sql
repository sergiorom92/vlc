
CREATE TABLE vidrio (
                id_vidrio INT AUTO_INCREMENT NOT NULL,
                grosor DOUBLE PRECISION NOT NULL,
                largo DOUBLE PRECISION NOT NULL,
                ancho DOUBLE PRECISION NOT NULL,
                precio DOUBLE PRECISION NOT NULL,
                descripcion VARCHAR (250) NOT NULL,
                disponible BOOLEAN NOT NULL,
                PRIMARY KEY (id_vidrio)
);


CREATE TABLE persona (
                id_persona VARCHAR (250) NOT NULL,
                nombre VARCHAR (250) NOT NULL,
                apellido VARCHAR (250) NOT NULL,
                direccion VARCHAR (250) NOT NULL,
                ciudad VARCHAR (250) NOT NULL,
                telefono VARCHAR (250) NOT NULL,
                PRIMARY KEY (id_persona)
);


CREATE TABLE empleado (
                id_empleado VARCHAR (250) NOT NULL,
                id_persona VARCHAR (250) NOT NULL,
                gerente BOOLEAN NOT NULL,
                contrasena VARCHAR (250) NOT NULL,
                PRIMARY KEY (id_empleado)
);


CREATE TABLE factura (
                factura_id INT AUTO_INCREMENT NOT NULL,
                fecha DATE NOT NULL,
                id_empleado VARCHAR (250) NOT NULL,
                id_persona VARCHAR (250) NOT NULL,
                id_empleado_corte VARCHAR (250) NOT NULL,
                PRIMARY KEY (factura_id)
);



CREATE TABLE detalle_factura (
                id INT AUTO_INCREMENT NOT NULL,
                id_vidrio INT NOT NULL,
                factura_id INT NOT NULL,
                PRIMARY KEY (id)
);

CREATE TABLE cotizacion (
                cotizacion_id INT NOT NULL,
                id_empleado VARCHAR (250) NOT NULL,
                id_persona VARCHAR (250) NOT NULL,
                PRIMARY KEY (cotizacion_id)
);



CREATE TABLE detalle_cotizacion (
                id INT AUTO_INCREMENT NOT NULL,
                id_vidrio INT NOT NULL,
                cotizacion_id INT NOT NULL,
                PRIMARY KEY (id)
);



ALTER TABLE detalle_factura ADD CONSTRAINT vidrio_detalle_factura_fk
FOREIGN KEY (id_vidrio)
REFERENCES vidrio (id_vidrio)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE detalle_cotizacion ADD CONSTRAINT vidrio_detalle_cotizacion_fk
FOREIGN KEY (id_vidrio)
REFERENCES vidrio (id_vidrio)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE empleado ADD CONSTRAINT persona_empleado_fk
FOREIGN KEY (id_persona)
REFERENCES persona (id_persona)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE factura ADD CONSTRAINT persona_factura_fk
FOREIGN KEY (id_persona)
REFERENCES persona (id_persona)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE cotizacion ADD CONSTRAINT persona_cotizacion_fk
FOREIGN KEY (id_persona)
REFERENCES persona (id_persona)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE cotizacion ADD CONSTRAINT empleado_cotizacion_fk
FOREIGN KEY (id_empleado, id_persona)
REFERENCES empleado (id_empleado, id_persona)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE factura ADD CONSTRAINT empleado_factura_fk
FOREIGN KEY (id_empleado, id_persona)
REFERENCES empleado (id_empleado, id_persona)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE factura ADD CONSTRAINT empleado_factura_fk1
FOREIGN KEY (id_empleado_corte, id_persona)
REFERENCES empleado (id_empleado, id_persona)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE detalle_factura ADD CONSTRAINT factura_detalle_factura_fk
FOREIGN KEY (factura_id)
REFERENCES factura (factura_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE detalle_cotizacion ADD CONSTRAINT cotizacion_detalle_cotizacion_fk
FOREIGN KEY (cotizacion_id)
REFERENCES cotizacion (cotizacion_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;