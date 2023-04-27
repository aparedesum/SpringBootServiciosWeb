drop table if exists libro;

CREATE TABLE libro
(
    id             INT          NOT NULL AUTO_INCREMENT,
    titulo         VARCHAR(255) NOT NULL,
    autor          VARCHAR(255) NOT NULL,
    descripcion    VARCHAR(255),
    precio         DECIMAL(10, 2),
    fecha_publicacion DATE,
    stock          INT,
    PRIMARY KEY (id)
);