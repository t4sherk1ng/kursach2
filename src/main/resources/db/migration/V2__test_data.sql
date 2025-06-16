INSERT INTO restaurant (name) VALUES ('Pizza Hut');
INSERT INTO restaurant (name) VALUES ('Burger King');

INSERT INTO menu_item (name, price, restaurant_id) VALUES ('Pepperoni Pizza', 9.99, 1);
INSERT INTO menu_item (name, price, restaurant_id) VALUES ('Margherita Pizza', 8.99, 1);
INSERT INTO menu_item (name, price, restaurant_id) VALUES ('Whopper', 5.99, 2);
INSERT INTO menu_item (name, price, restaurant_id) VALUES ('Cheeseburger', 2.99, 2);

INSERT INTO users (email, phone, address) VALUES ('user1@example.com', '+1234567890', '123 Main St');
INSERT INTO users (email, phone, address) VALUES ('user2@example.com', '+0987654321', '456 Elm St');