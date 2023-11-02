INSERT INTO product_type (name) VALUES ('Pneu')
INSERT INTO product_type (name) VALUES ('Parachoque')

INSERT INTO product (name, description, type_id) VALUES ('Pirelli Scorpion 16"', 'Pneu para SVU', 1)
INSERT INTO product (name, description, type_id) VALUES ('Pirelli Sport Demon', 'Pneu para motos 250cc', 1)
INSERT INTO product (name, description, type_id) VALUES ('Parachoque Dianteiro Vectra', 'Vectra de 96 até 2005', 2)
INSERT INTO product (name, description, type_id) VALUES ('Parachoque Traseiro Vectra', 'Vectra de 96 até 2005', 2)

INSERT INTO stock (product_id, quantity, unit_price) VALUES (1, 4, 600.00)
INSERT INTO stock (product_id, quantity, unit_price) VALUES (2, 4, 400.00)
INSERT INTO stock (product_id, quantity, unit_price) VALUES (3, 2, 1200.00)
INSERT INTO stock (product_id, quantity, unit_price) VALUES (4, 2, 1200.00)
