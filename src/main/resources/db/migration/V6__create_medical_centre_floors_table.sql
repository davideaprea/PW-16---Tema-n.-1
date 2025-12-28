CREATE TABLE IF NOT EXISTS medical_centre_floors (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,

    medical_centre_id BIGINT NOT NULL,
    number INTEGER NOT NULL,

    CONSTRAINT fk_floor_medical_centre
        FOREIGN KEY (medical_centre_id)
        REFERENCES medical_centres (id)
        ON DELETE CASCADE,

    CONSTRAINT uk_medical_centre_floor
        UNIQUE (medical_centre_id, number)
);

CREATE INDEX idx_floor_medical_centre
    ON medical_centre_floors (medical_centre_id);