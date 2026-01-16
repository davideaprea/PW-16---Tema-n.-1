CREATE TABLE bookings (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    patient_id BIGINT NOT NULL,
    expected_start_time TIMESTAMP NOT NULL,
    estimated_end_time TIMESTAMP NOT NULL,
    medical_care_id BIGINT NOT NULL,
    medic_time_slot_id BIGINT NOT NULL,
    booking_status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    payment_status VARCHAR(50) NOT NULL,
    total_price DECIMAL(19, 2) NOT NULL,

    CONSTRAINT fk_booking_patient_id
            FOREIGN KEY (patient_id)
            REFERENCES patients (id),
    CONSTRAINT fk_booking_medical_care_id
                FOREIGN KEY (medical_care_id)
                REFERENCES medical_care (id),
    CONSTRAINT fk_booking_medic_time_slot_id
                FOREIGN KEY (medic_time_slot_id)
                REFERENCES medics_time_slots (id)
);

CREATE INDEX idx_bookings_medic_time_slot_id ON bookings (medic_time_slot_id);
CREATE INDEX idx_bookings_patient_id ON bookings (patient_id);
CREATE INDEX idx_bookings_medical_care_id ON bookings (medical_care_id);