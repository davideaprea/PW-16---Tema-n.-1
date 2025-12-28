CREATE TABLE IF NOT EXISTS medical_centres (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,

    address_id BIGINT NOT NULL,

    email VARCHAR(255) NOT NULL,
    phone VARCHAR(50) NOT NULL,

    CONSTRAINT fk_medical_centre_address
        FOREIGN KEY (address_id)
        REFERENCES medical_centre_addresses (id)
        ON DELETE CASCADE,

    CONSTRAINT uk_medical_centre_address
        UNIQUE (address_id)
);