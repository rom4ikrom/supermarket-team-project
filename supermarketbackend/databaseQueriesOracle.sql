CREATE TABLE region (
	id NUMBER(5),
	name VARCHAR(50),
	is_active NUMBER(1),

	CONSTRAINT pk_region_id PRIMARY KEY (id)
);

CREATE TABLE supplier_detail (
	id NUMBER(5),
	company_name VARCHAR(100),
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(10),
	email VARCHAR(255),
	tel CHAR(15),
	password VARCHAR(60),
	enabled NUMBER(1),
	CONSTRAINT pk_supplier_id PRIMARY KEY(id)
);

CREATE TABLE product (
	id NUMBER(5),
	code VARCHAR(20),
	name VARCHAR(50),
	variety VARCHAR(50),
	description VARCHAR(500),
	price DECIMAL(10,2),
	quantity NUMBER(5),
	is_active NUMBER(1),
	country VARCHAR(50),
	region_id NUMBER(5),
	supplier_id NUMBER(5),
	purchases NUMBER(5) DEFAULT 0,
	views NUMBER(5) DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY (id),
	CONSTRAINT fk_product_region_id FOREIGN KEY (region_id) REFERENCES region (id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES supplier_detail (id)
);

CREATE TABLE user_detail (
	id NUMBER(5),
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(10),
	email VARCHAR(255),
	tel NUMBER(20),
	password VARCHAR(80),
	hint VARCHAR (100),
	enabled NUMBER(1),
	CONSTRAINT pk_user_id PRIMARY KEY(id)
);

CREATE TABLE supplier_order_item (
	id NUMBER(5),
	supplier_id NUMBER(5),
	product_id NUMBER(5),
	quantity NUMBER(5),
	sup_order_date DATE,
	CONSTRAINT fk_supplier_id FOREIGN KEY (supplier_id ) REFERENCES supplier_detail (id),
	CONSTRAINT fk_product_id FOREIGN KEY (product_id ) REFERENCES product (id),
	CONSTRAINT pk_supplier_order_item_id PRIMARY KEY(id)
);

CREATE TABLE address (
	id NUMBER(5),
	user_id NUMBER(5),
	address_line_one VARCHAR(255),
	address_line_two VARCHAR(255),
	town VARCHAR(100),
	county VARCHAR(100),
	postcode VARCHAR(20),
	country VARCHAR(50),
	is_billing NUMBER(1),
	is_shipping NUMBER(1),
	CONSTRAINT fk_address_user_id FOREIGN KEY (user_id ) REFERENCES user_detail (id),
	CONSTRAINT pk_address_id PRIMARY KEY(id)
);

-- the cart table to store the user cart top-level details
CREATE TABLE cart (
	id NUMBER(5),
	user_id NUMBER(5),
	grand_total DECIMAL(10,2),
	cart_lines NUMBER(5),
	CONSTRAINT fk_cart_user_id FOREIGN KEY (user_id ) REFERENCES user_detail (id),
	CONSTRAINT pk_cart_id PRIMARY KEY (id)
);

CREATE TABLE cart_line (
	id NUMBER(5),
	cart_id NUMBER(5),
	total DECIMAL(10,2),
	product_id NUMBER(5),
	product_count NUMBER(5),
	buying_price DECIMAL(10,2),
	is_available NUMBER(1),
	CONSTRAINT fk_cartline_product_id FOREIGN KEY (product_id ) REFERENCES product (id),
	CONSTRAINT pk_cartline_id PRIMARY KEY (id)
);

-- the order detail table to store the order

CREATE TABLE order_detail (
	id NUMBER(5),
	user_id NUMBER(5),
	order_total DECIMAL(10,2),
	order_count NUMBER(5),
	shipping_id NUMBER(5),
	billing_id NUMBER(5),
	order_date DATE,
	CONSTRAINT fk_order_detail_user_id FOREIGN KEY (user_id) REFERENCES user_detail (id),
	CONSTRAINT fk_order_detail_shipping_id FOREIGN KEY (shipping_id) REFERENCES address (id),
	CONSTRAINT fk_order_detail_billing_id FOREIGN KEY (billing_id) REFERENCES address (id),
	CONSTRAINT pk_order_detail_id PRIMARY KEY (id)
);

-- the order item table to store order items

CREATE TABLE order_item (
	id NUMBER(5),
	order_id NUMBER(5),
	total DECIMAL(10,2),
	product_id NUMBER(5),
	product_count NUMBER(5),
	buying_price DECIMAL(10,2),
	CONSTRAINT fk_order_item_product_id FOREIGN KEY (product_id) REFERENCES product (id),
	CONSTRAINT fk_order_item_order_id FOREIGN KEY (order_id) REFERENCES order_detail (id),
	CONSTRAINT pk_order_item_id PRIMARY KEY (id)
);
	
-- adding user details
INSERT INTO user_detail
VALUES (1, 'Roman', 'Romanov', 'ADMIN', 'admin@gmail.com', '1234567890', '$2a$10$wwmTKnYUjuck0vFsJznRa.NxJ9MbIuB0fYYtq9vfr.ogkSTmaxrQK', '12345', 1);

INSERT INTO address
VALUES (1, 1, '11 Park Road', 'Kingston', 'London', 'London City', 'AB11 12CD', 'UK', 1, 0); 

-- adding supplier details
INSERT INTO supplier_detail
VALUES (1, 'Company 1', 'Supplier', '1', 'SUP', 'sup1@gmail.com', '1234567890', '$2a$10$wwmTKnYUjuck0vFsJznRa.NxJ9MbIuB0fYYtq9vfr.ogkSTmaxrQK', 1);
INSERT INTO supplier_detail
VALUES (2 ,'Company 2', 'Supplier', '2', 'SUP', 'sup2@gmail.com', '1234567890', '$2a$10$wwmTKnYUjuck0vFsJznRa.NxJ9MbIuB0fYYtq9vfr.ogkSTmaxrQK', 1);
INSERT INTO supplier_detail
VALUES (3, 'Company 3', 'Supplier', '3', 'SUP', 'sup3@gmail.com', '1234567890', '$2a$10$wwmTKnYUjuck0vFsJznRa.NxJ9MbIuB0fYYtq9vfr.ogkSTmaxrQK', 1);
INSERT INTO supplier_detail
VALUES (4, 'Company 4', 'Supplier', '4', 'SUP', 'sup4@gmail.com', '1234567890', '$2a$10$wwmTKnYUjuck0vFsJznRa.NxJ9MbIuB0fYYtq9vfr.ogkSTmaxrQK', 1);
INSERT INTO supplier_detail
VALUES (5, 'Company 5', 'Supplier', '5', 'SUP', 'sup5@gmail.com', '1234567890', '$2a$10$wwmTKnYUjuck0vFsJznRa.NxJ9MbIuB0fYYtq9vfr.ogkSTmaxrQK', 1);

-- adding all regions
INSERT INTO region VALUES (1, 'Africa', 1);
INSERT INTO region VALUES (2, 'Australia', 1);
INSERT INTO region VALUES (3,'Asia', 1);
INSERT INTO region VALUES (4, 'Europe', 1);
INSERT INTO region VALUES (5, 'North America', 1);
INSERT INTO region VALUES (6, 'Central America', 1);
INSERT INTO region VALUES (7, 'South America', 1);

-- adding products info from Africa
INSERT INTO product
VALUES(1, 'PRD_ABC112', 'Pineapple', 'Queen', 'Considered the best in the world, queen pineapple is very sweet and its
	exceptional aroma, irresistible taste and bright colour make it unparalleled', 3, 30, 1, 'South Africa', 1, 3, 12, 25);

-- adding products info from Australia
INSERT INTO product
VALUES(2, 'PRD_ABC114', 'Apricot', 'Dwarf Divinity', 'Dwarf Divinity apricot, a fruit with a good sweet flavour,
	excellent drying or fresh eating, probably one of the best early season apricots in most areas', 5, 32, 1, 'Australia', 2, 4, 8, 15);
INSERT INTO product
VALUES(3, 'PRD_ABC115', 'Blueberry', 'Puru', 'Fruit is light blue, small recessed scar with exceptional highly aromatic
		flavour', 4, 60, 1, 'Australia', 2, 4, 30, 50);

-- adding products info from Asia
INSERT INTO product
VALUES (17, 'PRD_ABC111', 'Apple', 'Fuji', 'Enjoy the full flavor of a Fuji! A crunchy, super-sweet and flavor-forward
apple, the Fuji can be enjoyed as an everyday snack as well as in pies, sauces, baking and more..',
15, 5, 1, 'Japan', 3, 1, 0, 0 );
INSERT INTO product
VALUES(4, 'PRD_ABC116', 'Jackfruit', 'Jackfruit', 'Ripe jackfruit is naturally sweet, with subtle flavouring. It can be
	used to make a variety of dishes, including custards and cakes', 7, 25, 1, 'Bangladesh', 3, 1, 15, 50);
INSERT INTO product
VALUES(5, 'PRD_ABC117', 'Lychee', 'Lychee', 'A fruit that exposes a layer of translucent white fleshy aril with a floral
	smell and a fragrant, sweet flavour', 10, 18, 1, 'China', 3, 1, 26, 30);

-- adding products info from Europe
INSERT INTO product
VALUES (6, 'PRD_AA14B1', 'Apple', 'Golden', 'The Golden Delicious is a perfect pick for any recipe. Sweet and mellow, this
crisp apple has a tender golden skin, and its flesh stays white after slicing for longer than other apple varieties.
Reach for a Golden Delicious as an all-purpose apple for snacking, salads, baking, freezing, sauces, and more.',
12, 5, 1, 'Poland', 4, 1, 0, 0 );
INSERT INTO product
VALUES (7, 'PRD_45F54F', 'Apple', 'Gala', 'You’ll go gaga for Gala! This crisp, aromatically-sweet apple features
pink-orange stripes atop a pretty yellow background. Delicious in salads, pies, and sauces, the Gala’s popularity is on
the rise around the world.', 10, 5, 1, 'Ukraine', 4, 1, 0, 0 );
INSERT INTO product
VALUES(8, 'PRD_ABC119', 'Melon', 'Watermelon', 'A refreshing fruit full of sweetness and vitamins', 4, 50, 1, 'Greece', 4, 1, 40, 55);

-- adding products info from North America
INSERT INTO product 
VALUES (9, 'PRD_ABC222', 'Apple', 'Honeycrisp', 'The Honeycrisp apple’s name says it all! Pleasantly crisp, sweet and
juicy, this popular apple features a beautiful bright red skin mottled with pale green. Its complex flavor is subtly
tart, and is a versatile ingredient for recipes ranging from sweet to savory. As a snack, Honeycrisp apples burst with
juice with every bite, and they are also a delicious addition to salads, pies, sauces, and baked goods.',
13, 5, 1, 'USA', 5, 2, 0, 0 );
INSERT INTO product
VALUES(10, 'PRD_ABC118', 'Cranberries', 'Granite Red', 'A bit of a sour flavour but very healthy and efficient on keeping
	the immune system strong', 3, 45, 1, 'USA', 5, 2, 23, 34);
INSERT INTO product
VALUES(11, 'PRD_ABC120', 'Strawberries', 'Sparkle Strawberry', 'Sparkle is a very hardy, flavourful variety introduced
		60 years ago but still is very popular because of its flavour. Excellent for jam and freezing', 2, 100, 1, 'USA', 5, 2, 80, 150);

-- adding products info from Central America
INSERT INTO product
VALUES(12, 'PRD_ABC121', 'Dragon Fruit', 'Pitaya', 'Its flavour is mildly sweet, like a blend of kiwi and pear, and has a
	crunchy texture', 10, 40, 1, 'Mexico', 6, 2, 20, 60);
INSERT INTO product
VALUES(13, 'PRD_ABC122', 'Mangosteen', 'Mangosteen', 'The fruit of the mangosteen is sweet and tangy, juicy, somewhat
	fibrous, with fluid-filled vesicles, with an inedible, deep reddish-purple coloured rind when ripe', 13, 15, 1, 'Florida', 6, 2, 3, 10);

-- adding products info from South America
INSERT INTO product
VALUES(14, 'PRD_ABC123', 'Gooseberry', 'Cape Gooseberry', 'It is bright yellow to orange in colour, and sweet when ripe,
	with a characteristic, mildly tart tomato flavour', 10, 10, 1, 'Peru', 7, 5, 2, 7);
INSERT INTO product
VALUES(15, 'PRD_ABC124', 'Carambola', 'Star fruit', 'Inside, its crispy, with juicy pulp and mildly sweet. It is rich
	in vitamin C', 13, 25, 1, 'Brazil', 7, 5, 12, 16);
INSERT INTO product
VALUES(16, 'PRD_ABB100', 'Passion Fruit', 'Purple', 'Purple passionfruit is a small, oval to round shaped fruit, approximately
	two to three inches in diameter at maturity. The fruits skin is smooth, yet dimpled and at peak maturity can be heavily
	wrinkled. Below the skin is a cottony white peel. The interior seed cavity of Purple passionfruit is filled with edible
	yellow to green jelly and medium sized black seeds. Its pulp is highly aromatic and has a tropical sweet tart flavor with
	nuances of pineapple, papaya, mango, citrus and guava. ', 22, 15, 1, 'Paraguay', 7, 5, 2, 14);
