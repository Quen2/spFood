CREATE TABLE users (
    US_ID INT AUTO_INCREMENT PRIMARY KEY,
    US_lastname VARCHAR(100) NOT NULL,
    US_firstname VARCHAR(150) NOT NULL,
    US_role VARCHAR(150) NOT NULL,
    US_password VARCHAR(255) NOT NULL,
    US_phone VARCHAR(10) NOT NULL,
    US_email VARCHAR(150) NOT NULL UNIQUE
);

CREATE TABLE recipes (
    RE_ID INT AUTO_INCREMENT PRIMARY KEY,
    RE_name VARCHAR(100) NOT NULL,
    RE_preparation_time INTEGER NOT NULL,
    RE_cooking_time INTEGER NOT NULL,
    RE_cal INTEGER NOT NULL,
    RE_visibility BIT DEFAULT FALSE,
    US_ID INT NOT NULL,

    CONSTRAINT fk_recipe_user
            FOREIGN KEY (US_ID)
            REFERENCES users(US_ID)
            ON DELETE CASCADE
);

CREATE TABLE products (
    PR_ID INT AUTO_INCREMENT PRIMARY KEY,
    PR_lib VARCHAR(100) NOT NULL,
    PR_type VARCHAR(100) NOT NULL,
    PR_cal INTEGER NOT NULL
);

CREATE TABLE recipes_products (
    RP_ID INT AUTO_INCREMENT PRIMARY KEY,
    RE_ID INT NOT NULL,
    PR_ID INT NOT NULL,
    RP_quantity INT NOT NULL,

    CONSTRAINT fk_rp_recipe
        FOREIGN KEY (RE_ID)
        REFERENCES recipes(RE_ID)
        ON DELETE CASCADE,

    CONSTRAINT fk_rp_product
        FOREIGN KEY (PR_ID)
        REFERENCES products(PR_ID),

    CONSTRAINT uq_recipe_product
        UNIQUE (RE_ID, PR_ID)
);

CREATE TABLE user_favorite_recipes (
    US_ID INT NOT NULL,
    RE_ID INT NOT NULL,

    PRIMARY KEY (US_ID, RE_ID),

    CONSTRAINT fk_fav_user
        FOREIGN KEY (US_ID)
        REFERENCES users(US_ID)
        ON DELETE CASCADE,

    CONSTRAINT fk_fav_recipe
        FOREIGN KEY (RE_ID)
        REFERENCES recipes(RE_ID)
        ON DELETE CASCADE
);

INSERT INTO users (US_lastname, US_firstname, US_role, US_password, US_phone, US_email) VALUES
('Dupont', 'Alice', 'USER', '$2a$10$hashalice', '0612345678', 'alice.dupont@mail.com'),
('Martin', 'Bob', 'USER', '$2a$10$hashbob', '0623456789', 'bob.martin@mail.com'),
('Admin', 'Root', 'ADMIN', '$2a$10$hashadmin', '0600000000', 'admin@mail.com');

INSERT INTO products (PR_lib, PR_type, PR_cal) VALUES
('Tomate', 'LEGUMES', 18),
('Poulet', 'VIANDE', 165),
('Pomme', 'FRUITS', 52),
('Fromage', 'VIANDE', 402),
('Eau', 'BOISSON', 0),
('Huile d’olive', 'BOISSON', 884);

INSERT INTO recipes (RE_name, RE_preparation_time, RE_cooking_time, RE_cal, RE_visibility, US_ID) VALUES
('Salade de tomates', 10, 0, 120, TRUE, 1),
('Poulet rôti', 20, 60, 650, TRUE, 2),
('Compote de pommes', 15, 30, 200, FALSE, 1),
('Fromage & fruits', 5, 0, 350, TRUE, 3);

INSERT INTO recipes_products (RE_ID, PR_ID, RP_quantity) VALUES
(1, 1, 200),
(1, 6, 10),

(2, 2, 500),
(2, 6, 15),

(3, 3, 300),
(3, 5, 100),

(4, 4, 100),
(4, 3, 150);

INSERT INTO user_favorite_recipes (US_ID, RE_ID) VALUES
(1, 2),
(1, 4),
(2, 1),
(3, 2);
