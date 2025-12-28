CREATE TABLE IF NOT EXISTS cities (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,

    name VARCHAR(40) NOT NULL,
    zip_code VARCHAR(5) NOT NULL,

    province_id BIGINT,
    region_id BIGINT NOT NULL,

    CONSTRAINT uk_cities_name UNIQUE (name),
    CONSTRAINT uk_cities_zip_code UNIQUE (zip_code),

    CONSTRAINT fk_cities_region
        FOREIGN KEY (region_id)
        REFERENCES regions (id),

    CONSTRAINT fk_cities_province
        FOREIGN KEY (province_id)
        REFERENCES cities (id)
);

CREATE INDEX idx_city_region ON cities (region_id);