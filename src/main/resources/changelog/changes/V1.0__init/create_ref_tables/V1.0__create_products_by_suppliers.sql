CREATE TABLE products_by_suppliers
(
	id  INTEGER NOT NULL AUTO_INCREMENT,
	id_products  INTEGER NOT NULL,
	id_suppliers  INTEGER NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY R_3 (id_products) REFERENCES products(id),
	FOREIGN KEY R_4 (id_suppliers) REFERENCES suppliers(id)
);