CREATE TABLE customer
(
  id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(125) NOT NULL
);
CREATE UNIQUE INDEX customer_name_uindex ON customer (name);
