CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       email VARCHAR(255) UNIQUE NOT NULL,
                       phone VARCHAR(50),
                       address TEXT
);

CREATE TABLE restaurant (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(255) NOT NULL
);

CREATE TABLE menu_item (
                           id SERIAL PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           price DECIMAL(10,2) NOT NULL,
                           available BOOLEAN DEFAULT TRUE,
                           restaurant_id BIGINT REFERENCES restaurant(id)
);

CREATE TABLE orders (
                        id SERIAL PRIMARY KEY,
                        user_id BIGINT REFERENCES users(id),
                        restaurant_id BIGINT REFERENCES restaurant(id),
                        total_price DECIMAL(10,2) NOT NULL,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        status VARCHAR(20) NOT NULL
);

CREATE TABLE order_items (
                             order_id BIGINT REFERENCES orders(id),
                             item_id BIGINT REFERENCES menu_item(id),
                             PRIMARY KEY (order_id, item_id)
);