CREATE DATABASE IF NOT EXISTS KN_funding_User;
USE KN_funding_User;


CREATE TABLE user (
    id INT NOT NULL AUTO_INCREMENT,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone_number VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    is_active BOOLEAN DEFAULT TRUE,
    PRIMARY KEY (id)
);


CREATE TABLE category (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE requests (
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    category_id INT,
    user_id INT,
    amount DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (category_id) REFERENCES category(id),
    FOREIGN KEY (user_id) REFERENCES user(id)
);

USE KN_funding_User;

INSERT INTO User (full_name, email, phone_number, password, is_active)
VALUES ('karthikeyan', 'karthiKN352004@gmail.com', '7010847986', 'Sollamattn123', TRUE);

INSERT INTO User (full_name, email, phone_number, password, is_active)
VALUES ('christie', 'christie@gmail.com', '9790821440', 'adhuYedhuku123', TRUE);

INSERT INTO User (full_name, email, phone_number, password, is_active)
VALUES ('Pks', 'formido@gmail.com', '7010847986', 'formiDO123', TRUE);

USE KN_funding_User;

INSERT INTO Category (name)
VALUES ('Medical');

INSERT INTO Category (name)
VALUES ('Education');

INSERT INTO Category (name)
VALUES ('Temple');

INSERT INTO Category (name)
VALUES ('Animal Welfar');

INSERT INTO Category (name)
VALUES ('Children');

INSERT INTO Category (name)
VALUES ('Natural Disaster');


USE KN_funding_User;

INSERT INTO Requests (title, description, category_id, user_id, amount)
VALUES ('Contribute to save the life of Tushar', 'Tushar Koul from Durga Nagar, Jammu has met with an unfortunate accident. He was in Comma with multiple head injuries. Contribute and share the campaign to save him.', 1, 1, 100000);

INSERT INTO Requests (title, description, category_id, user_id, amount)
VALUES ('Private School Teacher needs your Support to Fight Blood Cancer', 'Hello, I am Dr. Bharti Srivastava a teacher by profession and I am at the crossroads of life where I am looking for your support in my fight for my life as I am suffering from lymphoma stage 2.', 2, 2, 200000);










