CREATE OR REPLACE PROCEDURE sp_insert_and_list_products (
    id_producto       IN INTEGER,
    nombre            IN VARCHAR2,
    fec_registro      IN DATE,
    list_producto     OUT SYS_REFCURSOR,
    codigo_respuesta  OUT INTEGER,
    mensaje_respuesta OUT VARCHAR2
) IS
BEGIN
    INSERT INTO tbl_producto (
        id_producto,
        nombre,
        fec_registro
    ) VALUES (
        id_producto,
        nombre,
        fec_registro
    );

    OPEN list_producto FOR SELECT
                              id_producto,
                              nombre,
                              fec_registro
                          FROM
                              tbl_producto;

    codigo_respuesta := 0;
    mensaje_respuesta := 'Ejecucion con existo';
EXCEPTION
    WHEN OTHERS THEN
        codigo_respuesta := 1;
        mensaje_respuesta := 'Mensaje : '
                             || sqlerrm
                             || ' Codigo :'
                             || sqlcode;
END;

CREATE TABLE tbl_producto (
    id_producto  INTEGER,
    nombre       VARCHAR2(200),
    fec_registro DATE
);

ALTER TABLE tbl_producto ADD CONSTRAINT pk_producto PRIMARY KEY ( id_producto );