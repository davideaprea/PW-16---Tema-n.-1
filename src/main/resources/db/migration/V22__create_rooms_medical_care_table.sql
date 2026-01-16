CREATE TABLE centres_services (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    medical_care_id BIGINT NOT NULL,
    room_id BIGINT NOT NULL,
    price DECIMAL(19, 2) NOT NULL,
    CONSTRAINT uk_medical_care_room_id UNIQUE (room_id, medical_care_id),
    CONSTRAINT fk_medical_care FOREIGN KEY (medical_care_id)
        REFERENCES medical_care (id)
);
