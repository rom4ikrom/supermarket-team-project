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
	description VARCHAR(500),
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
INSERT INTO product(code, name, variety, description, price, quantity, is_active, country, region_id, purchases, views)
VALUES('PRD_ABC112', 'Pineapple', 'Queen', 'Considered the best in the world, queen pineapple is very sweet and its
	exceptional aroma, irresistible taste and bright colour make it unparalleled', 3, 30, TRUE, 'South Africa', 1, 12, 25);

-- adding products info from Australia
INSERT INTO product(code, name, variety, description, price, quantity, is_active, country, region_id, purchases, views)
VALUES('PRD_ABC114', 'Apricot', 'Dwarf Divinity', 'Dwarf Divinity apricot, a fruit with a good sweet flavour,
	excellent drying or fresh eating, probably one of the best early season apricots in most areas', 5, 32, TRUE, 'Australia', 2, 8, 15);
INSERT INTO product(code, name, variety, description, price, quantity, is_active, country, region_id, purchases, views)
VALUES('PRD_ABC115', 'Blueberry', 'Puru', 'Fruit is light blue, small recessed scar with exceptional highly aromatic
		flavour', 4, 60, TRUE, 'Australia', 2, 30, 50);

-- adding products info from Asia
INSERT INTO product (code, name, variety, description, price, quantity, is_active, country, region_id, purchases, views)
VALUES ('PRD_ABC111', 'Apple', 'Fuji', 'Enjoy the full flavor of a Fuji! A crunchy, super-sweet and flavor-forward
apple, the Fuji can be enjoyed as an everyday snack as well as in pies, sauces, baking and more..',
15, 5, true, 'Japan', 3, 0, 0 );
INSERT INTO product(code, name, variety, description, price, quantity, is_active, country, region_id, purchases, views)
VALUES('PRD_ABC116', 'Jackfruit', 'Jackfruit', 'Ripe jackfruit is naturally sweet, with subtle flavouring. It can be
	used to make a variety of dishes, including custards and cakes', 7, 25, TRUE, 'Bangladesh', 3, 15, 50);
INSERT INTO product(code, name, variety, description, price, quantity, is_active, country, region_id, purchases, views)
VALUES('PRD_ABC117', 'Lychee', 'Lychee', 'A fruit that exposes a layer of translucent white fleshy aril with a floral
	smell and a fragrant, sweet flavour', 10, 18, TRUE, 'China', 3, 26, 30);

-- adding products info from Europe
INSERT INTO product (code, name, variety, description, price, quantity, is_active, country, region_id, purchases, views)
VALUES ('PRD_AA14B1', 'Apple', 'Golden', 'The Golden Delicious is a perfect pick for any recipe. Sweet and mellow, this
crisp apple has a tender golden skin, and its flesh stays white after slicing for longer than other apple varieties.
Reach for a Golden Delicious as an all-purpose apple for snacking, salads, baking, freezing, sauces, and more.',
12, 5, true, 'Poland', 4, 0, 0 );
INSERT INTO product (code, name, variety, description, price, quantity, is_active, country, region_id, purchases, views)
VALUES ('PRD_45F54F', 'Apple', 'Gala', 'You’ll go gaga for Gala! This crisp, aromatically-sweet apple features
pink-orange stripes atop a pretty yellow background. Delicious in salads, pies, and sauces, the Gala’s popularity is on
the rise around the world.', 10, 5, true, 'Ukraine', 4, 0, 0 );
INSERT INTO product(code, name, variety, description, price, quantity, is_active, country, region_id, purchases, views)
VALUES('PRD_ABC119', 'Melon', 'Watermelon', 'A refreshing fruit full of sweetness and vitamins', 4, 50, TRUE, 'Greece', 4, 40, 55);

-- adding products info from North America
INSERT INTO product (code, name, variety, description, price, quantity, is_active, country, region_id, purchases, views)
VALUES ('PRD_ABC222', 'Apple', 'Honeycrisp', 'The Honeycrisp apple’s name says it all! Pleasantly crisp, sweet and
juicy, this popular apple features a beautiful bright red skin mottled with pale green. Its complex flavor is subtly
tart, and is a versatile ingredient for recipes ranging from sweet to savory. As a snack, Honeycrisp apples burst with
juice with every bite, and they are also a delicious addition to salads, pies, sauces, and baked goods.',
13, 5, true, 'USA', 5, 0, 0 );
INSERT INTO product(code, name, variety, description, price, quantity, is_active, country, region_id, purchases, views)
VALUES('PRD_ABC118', 'Cranberries', 'Granite Red', 'A bit of a sour flavour but very healthy and efficient on keeping
	the immune system strong', 3, 45, TRUE, 'USA', 5, 23, 34);
INSERT INTO product(code, name, variety, description, price, quantity, is_active, country, region_id, purchases, views)
VALUES('PRD_ABC120', 'Strawberries', 'Sparkle Strawberry', 'Sparkle is a very hardy, flavourful variety introduced
		60 years ago but still is very popular because of its flavour. Excellent for jam and freezing', 2, 100, TRUE, 'USA', 5, 80, 150);

-- adding products info from Central America
INSERT INTO product(code, name, variety, description, price, quantity, is_active, country, region_id, purchases, views)
VALUES('PRD_ABC121', 'Dragon Fruit', 'Pitaya', 'Its flavour is mildly sweet, like a blend of kiwi and pear, and has a
	crunchy texture', 10, 40, TRUE, 'Mexico', 6, 20, 60);
INSERT INTO product(code, name, variety, description, price, quantity, is_active, country, region_id, purchases, views)
VALUES('PRD_ABC122', 'Mangosteen', 'Mangosteen', 'The fruit of the mangosteen is sweet and tangy, juicy, somewhat
	fibrous, with fluid-filled vesicles, with an inedible, deep reddish-purple coloured rind when ripe', 13, 15, TRUE, 'Florida', 6, 3, 10);

-- adding products info from South America
INSERT INTO product(code, name, variety, description, price, quantity, is_active, country, region_id, purchases, views)
VALUES('PRD_ABC123', 'Gooseberry', 'Cape Gooseberry', 'It is bright yellow to orange in colour, and sweet when ripe,
	with a characteristic, mildly tart tomato flavour', 10, 10, TRUE, 'Peru', 7, 2, 7);
INSERT INTO product(code, name, variety, description, price, quantity, is_active, country, region_id, purchases, views)
VALUES('PRD_ABC124', 'Carambola', 'Star fruit', 'Inside, its crispy, with juicy pulp and mildly sweet. It is rich
	in vitamin C', 13, 25, TRUE, 'Brazil', 7, 12, 16);
INSERT INTO product(code, name, variety, description, price, quantity, is_active, country, region_id, purchases, views)
VALUES('PRD_ABB100', 'Passion Fruit', 'Purple', 'Purple passionfruit is a small, oval to round shaped fruit, approximately
	two to three inches in diameter at maturity. The fruits skin is smooth, yet dimpled and at peak maturity can be heavily
	wrinkled. Below the skin is a cottony white peel. The interior seed cavity of Purple passionfruit is filled with edible
	yellow to green jelly and medium sized black seeds. Its pulp is highly aromatic and has a tropical sweet tart flavor with
	nuances of pineapple, papaya, mango, citrus and guava. ', 22, 15, TRUE, 'Paraguay', 7, 2, 14);
