CREATE TABLE IF NOT EXISTS medical_centre_addresses (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,

    name VARCHAR(255) NOT NULL,
    number VARCHAR(20) NOT NULL,

    latitude NUMERIC(9,6) NOT NULL,
    longitude NUMERIC(9,6) NOT NULL,

    notes VARCHAR(500),

    city_id BIGINT NOT NULL,

    CONSTRAINT fk_address_city
        FOREIGN KEY (city_id)
        REFERENCES cities (id),

    CONSTRAINT uk_city_street_number
        UNIQUE (city_id, street_name, street_number),

    CONSTRAINT uk_address_coordinates
        UNIQUE (latitude, longitude)
);
