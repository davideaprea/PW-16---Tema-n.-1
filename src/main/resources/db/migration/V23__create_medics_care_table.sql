CREATE TABLE medics_qualification (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    medic_id BIGINT NOT NULL,
    medical_care_id BIGINT NOT NULL,
    CONSTRAINT uk_medic_care UNIQUE (medic_id, medical_care_id),
    CONSTRAINT fk_medical_care
        FOREIGN KEY (medical_care_id)
        REFERENCES medical_care(id)
);
