CREATE TABLE IF NOT EXISTS `myschema`.`mytable`
(
    `id`   INT NOT NULL,
    `name` VARCHAR(45) NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `myschema`.`products`
(
    `id`   INT NOT NULL,
    `name` VARCHAR(45) NULL,
    `cost` INT NOT NULL,
    PRIMARY KEY (`id`)
);
