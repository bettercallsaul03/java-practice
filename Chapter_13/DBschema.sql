CREATE TABLE regions (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         area VARCHAR(100),
                         population_type_id INT,
                         FOREIGN KEY (population_type_id) REFERENCES population_types(id)
);

CREATE TABLE weather (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         region_id INT NOT NULL,
                         date DATE NOT NULL,
                         temperature DECIMAL(5, 2),
                         precipitation VARCHAR(50),
                         FOREIGN KEY (region_id) REFERENCES regions(id)
);

CREATE TABLE population_types (
                                  id INT AUTO_INCREMENT PRIMARY KEY,
                                  name VARCHAR(100) NOT NULL,
                                  language VARCHAR(100)
);
