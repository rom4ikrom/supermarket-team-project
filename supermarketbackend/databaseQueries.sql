CREATE TABLE product (
	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	variety VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	country VARCHAR(50),
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY (id),
);

-- adding two products
INSERT INTO product (code, name, variety, description, unit_price, quantity, is_active, country, purchases, views)
VALUES ('PRDABC123DEFX', 'Apple', 'Golden', 'This is Apple Golden!', 18, 5, true, 'Poland', 0, 0 );
INSERT INTO product (code, name, variety, description, unit_price, quantity, is_active, country, purchases, views)
VALUES ('PRDABC123DEFC', 'Apple', 'Gala', 'This is Apple Gala!', 18, 5, true, 'Ukraine', 0, 0 );