CREATE TABLE client(
                       id IDENTITY PRIMARY KEY,
                       name VARCHAR (200) NOT NULL CHECK (CHAR_LENGTH (name) >3)
);

CREATE TABLE planet (
                        Id   VARCHAR  PRIMARY KEY,
                        CHECK (ID=UPPER(id)),
                        name VARCHAR(500)
);

CREATE TABLE ticket (
                        id IDENTITY PRIMARY KEY,
                        created_at TIMESTAMP,
                        client_id BIGINT,
                        from_planet_id VARCHAR,
                        to_planet_id VARCHAR,
                        FOREIGN KEY (client_id) REFERENCES client(id) ON DELETE CASCADE,
                        FOREIGN KEY (from_planet_id) REFERENCES planet(id) ON DELETE CASCADE,
                        FOREIGN KEY (to_planet_id) REFERENCES planet(id) ON DELETE CASCADE
);


