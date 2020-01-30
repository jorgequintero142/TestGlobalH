CREATE TABLE venta
  (
     id_venta      NUMBER(10) NOT NULL PRIMARY KEY,
     id_producto   NUMBER(10),
     id_cliente    NUMBER(10),
     cantidad_prod INTEGER NOT NULL CHECK (cantidad_prod>0),
     fecha         DATE DEFAULT SYSDATE NOT NULL
  );

CREATE SEQUENCE sq_venta
  START WITH 1;

CREATE OR replace TRIGGER tr_venta
  BEFORE INSERT ON venta
  FOR EACH ROW
BEGIN
    SELECT sq_venta.NEXTVAL
    INTO   :new.id_venta
    FROM   dual;
END;

--DROP TABLE cliente;
--DROP SEQUENCE sq_cliente;
--DROP TRIGGER tr_cli;
CREATE TABLE cliente
  (
     id_cliente      NUMBER(10) NOT NULL PRIMARY KEY,
     nombre_completo VARCHAR2(100),
     tipo_documento  VARCHAR2(3) NOT NULL CHECK (tipo_documento IN ('CC', 'NIT',
     'PAS'
     )),
     num_documento   VARCHAR2(20) NOT NULL,
     CONSTRAINT cli_uq UNIQUE (tipo_documento, num_documento)
  );

CREATE SEQUENCE sq_cliente
  START WITH 1;

CREATE OR replace TRIGGER tr_cli
  BEFORE INSERT ON cliente
  FOR EACH ROW
BEGIN
    SELECT sq_cliente.NEXTVAL
    INTO   :new.id_cliente
    FROM   dual;
END;

/

--DROP TABLE producto;
--DROP SEQUENCE sq_producto;
--DROP TRIGGER tr_producto;

CREATE TABLE producto
  (
     id_producto     NUMBER(10) NOT NULL PRIMARY KEY,
     nombre_producto VARCHAR2(30) NOT NULL,
     desc_producto   VARCHAR2(200),
     precio          NUMERIC(6, 2) DEFAULT 0 NOT NULL CHECK (precio>0)
  );

CREATE SEQUENCE sq_producto
  START WITH 1;

CREATE OR replace TRIGGER tr_producto
  BEFORE INSERT ON producto
  FOR EACH ROW
BEGIN
    SELECT sq_producto.NEXTVAL
    INTO   :new.id_producto
    FROM   dual;
END;

/

