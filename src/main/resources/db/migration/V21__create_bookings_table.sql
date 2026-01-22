CREATE TABLE medical_examinations (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    patient_id BIGINT NOT NULL,
    expected_start_time TIMESTAMP NOT NULL,
    estimated_end_time TIMESTAMP NOT NULL,
    medical_care_id BIGINT NOT NULL,
    medic_time_slot_id BIGINT NOT NULL,
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    medic_id BIGINT NOT NULL,

    CONSTRAINT fk_medical_examination_patient_id
            FOREIGN KEY (patient_id)
            REFERENCES patients (id),
    CONSTRAINT fk_medical_examination_medical_care_id
                FOREIGN KEY (medical_care_id)
                REFERENCES medical_care (id),
    CONSTRAINT fk_medical_examination_medic_time_slot_id
                FOREIGN KEY (medic_time_slot_id)
                REFERENCES medics_time_slots (id),
    CONSTRAINT fk_medical_examination_medic_id
                FOREIGN KEY (medic_id)
                REFERENCES medics (id)
);

CREATE INDEX idx_medical_examinations_medic_time_slot_id ON medical_examinations (medic_time_slot_id);
CREATE INDEX idx_medical_examinations_patient_id ON medical_examinations (patient_id);
CREATE INDEX idx_medical_examinations_medical_care_id ON medical_examinations (medical_care_id);
CREATE INDEX idx_medical_examinations_medic_id ON medical_examinations (medic_id);