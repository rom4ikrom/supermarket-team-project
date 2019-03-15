CREATE TABLE region (

	id IDENTITY,
	name VARCHAR(50),
	is_active boolean,
	
	CONSTRAINT pk_region_id PRIMARY KEY (id)

);

CREATE TABLE product (
	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	variety VARCHAR(50),
	description VARCHAR(255),
	price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	country VARCHAR(50),
	region_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY (id),
	CONSTRAINT fk_product_region_id FOREIGN KEY (region_id) REFERENCES region (id),
);

-- adding all regions
INSERT INTO region (name, is_active) VALUES ('Africa', true);
INSERT INTO region (name, is_active) VALUES ('Australia', true);
INSERT INTO region (name, is_active) VALUES ('Asia', true);
INSERT INTO region (name, is_active) VALUES ('Europe', true);
INSERT INTO region (name, is_active) VALUES ('North America', true);
INSERT INTO region (name, is_active) VALUES ('Central America', true);
INSERT INTO region (name, is_active) VALUES ('South America', true);

-- adding products info from Africa

-- adding products info from Australia

-- adding products info from Asia

-- adding products info from Europe
INSERT INTO product (code, name, variety, description, price, quantity, is_active, country, region_id, purchases, views)
VALUES ('PRD_AA14B1', 'Apple', 'Golden', 'This is Apple Golden!', 18, 5, true, 'Poland', 4, 0, 0 );
INSERT INTO product (code, name, variety, description, price, quantity, is_active, country, region_id, purchases, views)
VALUES ('PRD_45F54F', 'Apple', 'Gala', 'This is Apple Gala!', 18, 5, true, 'Ukraine', 4, 0, 0 );

-- adding products info from Central America

-- adding products info from North America

-- adding products info from South America
