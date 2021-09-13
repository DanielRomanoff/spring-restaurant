CREATE TABLE meals_in_order
(
	id	  INTEGER NOT NULL AUTO_INCREMENT,
	id_order  INTEGER NOT NULL,
	id_meal   INTEGER NOT NULL,
	quantity  INTEGER NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY R_1 (id_meal) REFERENCES meals(id),
	FOREIGN KEY R_2 (id_order) REFERENCES orders(id)
);