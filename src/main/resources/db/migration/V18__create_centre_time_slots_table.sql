CREATE TABLE centre_time_slots (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    day_of_week INTEGER NOT NULL,
    calendar_id BIGINT NOT NULL,

    CONSTRAINT fk_centre_time_slot_calendar
        FOREIGN KEY (calendar_id)
        REFERENCES centre_calendars(id)
        ON DELETE CASCADE
);

CREATE INDEX idx_centre_time_slots_calendar_id ON centre_time_slots (calendar_id);