CREATE TABLE products_for_meal
(
	id  INTEGER NOT NULL AUTO_INCREMENT,
	weight  INTEGER NOT NULL,
	id_products  INTEGER NOT NULL,
	id_meal  INTEGER NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY R_5 (id_products) REFERENCES products(id),
	FOREIGN KEY R_6 (id_meal) REFERENCES meals(id)
);