CREATE TABLE medics_calendars (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    owner_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    valid_from TIMESTAMP NOT NULL,
    valid_to TIMESTAMP,
    notes VARCHAR(500),

    CONSTRAINT fk_owner_id_medic
        FOREIGN KEY (owner_id)
        REFERENCES medics (id)
);

CREATE INDEX idx_medic_calendar_owner_id ON medics_calendars (owner_id);