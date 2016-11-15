
CREATE TABLE vidrio (
                id_vidrio INT AUTO_INCREMENT NOT NULL,
                grosor DOUBLE PRECISION NOT NULL,
                largo DOUBLE PRECISION NOT NULL,
                ancho DOUBLE PRECISION NOT NULL,
                descripcion VARCHAR (250) NOT NULL,
                precio DOUBLE PRECISION NOT NULL,
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
                id_persona VARCHAR (250) NOT NULL,
                contrasena VARCHAR (250) NOT NULL,
                gerente BOOLEAN NOT NULL,
                PRIMARY KEY (id_persona)
);


CREATE TABLE cotizacion (
                id_persona VARCHAR (250) NOT NULL,
                id_cotizacion INT AUTO_INCREMENT NOT NULL,
                PRIMARY KEY (id_cotizacion)
);


CREATE TABLE detalle_cotizacion (
                id_persona VARCHAR (250) NOT NULL,
                id_cotizacion INT NOT NULL,
                id_vidrio INT NOT NULL,
                PRIMARY KEY (id_persona, id_cotizacion, id_vidrio)
);


CREATE TABLE factura (
                id_persona VARCHAR (250) NOT NULL,
                factura_id INT AUTO_INCREMENT NOT NULL,
                id_empleado_corte VARCHAR (250) NOT NULL,
                fecha DATE NOT NULL,
                PRIMARY KEY (factura_id)
);


CREATE TABLE detalle_venta (
                id_persona VARCHAR (250) NOT NULL,
                factura_id INT NOT NULL,
                id_vidrio INT NOT NULL,
                PRIMARY KEY (id_persona, factura_id, id_vidrio)
);


ALTER TABLE detalle_venta ADD CONSTRAINT vidrio_detalle_fk
FOREIGN KEY (id_vidrio)
REFERENCES vidrio (id_vidrio)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE detalle_cotizacion ADD CONSTRAINT vidrio_detalle_cotizacion_fk
FOREIGN KEY (id_vidrio)
REFERENCES vidrio (id_vidrio)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE factura ADD CONSTRAINT persona_factura_fk
FOREIGN KEY (id_persona)
REFERENCES persona (id_persona)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE empleado ADD CONSTRAINT persona_empleado_fk
FOREIGN KEY (id_persona)
REFERENCES persona (id_persona)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE cotizacion ADD CONSTRAINT persona_cotizacion_fk
FOREIGN KEY (id_persona)
REFERENCES persona (id_persona)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE factura ADD CONSTRAINT empleado_factura_fk
FOREIGN KEY (id_persona)
REFERENCES empleado (id_persona)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE cotizacion ADD CONSTRAINT empleado_cotizacion_fk
FOREIGN KEY (id_persona)
REFERENCES empleado (id_persona)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE detalle_cotizacion ADD CONSTRAINT cotizacion_detalle_cotizacion_fk
FOREIGN KEY (id_persona, id_cotizacion)
REFERENCES cotizacion (id_persona, id_cotizacion)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE detalle_venta ADD CONSTRAINT factura_detalle_fk
FOREIGN KEY (id_persona, factura_id)
REFERENCES factura (id_persona, factura_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

--SP's (PROCEDIMIENTOS ALMACENADOS)
--INSERTAR UNA PERSONA

--CREAR UN EMPLEADO

--INSERTAR UN VIDRIO

--REALIZAR



-- QUERY PARA AUTENTICAR UN USUARIO

-- SUGERIR MEJOR TIPO DE VIDRIO

-- QUERY DIEZ CLIENTES CON MÁS COMPRAS

-- MANIPULAR INVENTARIOS Y GENERAR COTIZACIONES Y VENTAS

-- HISTORIAL DE VENTAS

-- ESTADO ACTUAL DE INVENTARIOS