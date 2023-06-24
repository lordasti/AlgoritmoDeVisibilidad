/*Creamos las tablas necesarias*/
CREATE TABLE product
(
    id integer NOT NULL,
    sequence integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE size
(
    id integer NOT NULL,
    productId integer NOT NULL,
    backSoon boolean NOT NULL,
    special boolean NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE stock
(
    sizeId integer NOT NULL,
    quantity integer NOT NULL,
    PRIMARY KEY (sizeId)
);

/*Creamos las FK e indices*/
ALTER TABLE size ADD CONSTRAINT fk_size_product FOREIGN KEY (productId) REFERENCES product (id);
ALTER TABLE stock ADD CONSTRAINT fk_stock_size FOREIGN KEY (sizeId) REFERENCES size (id);

/*Informamos la tabla product*/
INSERT INTO product (id, sequence) VALUES (1,10);
INSERT INTO product (id, sequence) VALUES (2, 7);
INSERT INTO product (id, sequence) VALUES (3,15);
INSERT INTO product (id, sequence) VALUES (4,13);
INSERT INTO product (id, sequence) VALUES (5, 6);

/*Informamos la tabla size*/
INSERT INTO size (id, productId, backSoon, special) VALUES (11,1, true,false);
INSERT INTO size (id, productId, backSoon, special) VALUES (12,1,false,false);
INSERT INTO size (id, productId, backSoon, special) VALUES (13,1, true,false);
INSERT INTO size (id, productId, backSoon, special) VALUES (21,2,false,false);
INSERT INTO size (id, productId, backSoon, special) VALUES (22,2,false,false);
INSERT INTO size (id, productId, backSoon, special) VALUES (23,2, true, true);
INSERT INTO size (id, productId, backSoon, special) VALUES (31,3, true,false);
INSERT INTO size (id, productId, backSoon, special) VALUES (32,3, true,false);
INSERT INTO size (id, productId, backSoon, special) VALUES (33,3,false,false);
INSERT INTO size (id, productId, backSoon, special) VALUES (41,4,false,false);
INSERT INTO size (id, productId, backSoon, special) VALUES (42,4,false,false);
INSERT INTO size (id, productId, backSoon, special) VALUES (43,4,false,false);
INSERT INTO size (id, productId, backSoon, special) VALUES (44,4, true, true);
INSERT INTO size (id, productId, backSoon, special) VALUES (51,5, true,false);
INSERT INTO size (id, productId, backSoon, special) VALUES (52,5,false,false);
INSERT INTO size (id, productId, backSoon, special) VALUES (53,5,false,false);
INSERT INTO size (id, productId, backSoon, special) VALUES (54,5, true, true);

/*Informamos la tabla stock*/
INSERT INTO stock (sizeId, quantity) VALUES (11, 0);
INSERT INTO stock (sizeId, quantity) VALUES (12, 0);
INSERT INTO stock (sizeId, quantity) VALUES (13, 0);
INSERT INTO stock (sizeId, quantity) VALUES (22, 0);
INSERT INTO stock (sizeId, quantity) VALUES (31,10);
INSERT INTO stock (sizeId, quantity) VALUES (32,10);
INSERT INTO stock (sizeId, quantity) VALUES (33,10);
INSERT INTO stock (sizeId, quantity) VALUES (41, 0);
INSERT INTO stock (sizeId, quantity) VALUES (42, 0);
INSERT INTO stock (sizeId, quantity) VALUES (43, 0);
INSERT INTO stock (sizeId, quantity) VALUES (44,10);
INSERT INTO stock (sizeId, quantity) VALUES (51,10);
INSERT INTO stock (sizeId, quantity) VALUES (52,10);
INSERT INTO stock (sizeId, quantity) VALUES (53,10);
INSERT INTO stock (sizeId, quantity) VALUES (54,10);
