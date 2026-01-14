CREATE TABLE centre_calendars (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    owner_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    valid_from TIMESTAMP NOT NULL,
    valid_to TIMESTAMP,
    notes VARCHAR(500),

    CONSTRAINT fk_owner_id_centre
            FOREIGN KEY (owner_id)
            REFERENCES medical_centres (id)
);

CREATE INDEX idx_centre_calendar_owner_id ON centre_calendars (owner_id);