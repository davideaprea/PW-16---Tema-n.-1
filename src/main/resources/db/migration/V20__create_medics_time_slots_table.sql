CREATE TABLE medics_time_slots (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    day_of_week INTEGER NOT NULL,
    room_id BIGINT NOT NULL,
    medic_calendar_id BIGINT NOT NULL,

    CONSTRAINT fk_medic_time_slot_calendar_id
        FOREIGN KEY (medic_calendar_id)
        REFERENCES medics_calendars (id),

    CONSTRAINT fk_medic_time_slot_room_id
            FOREIGN KEY (room_id)
            REFERENCES medical_centre_floor_rooms (id)
);

CREATE INDEX idx_medics_time_slots_room_id ON medics_time_slots (room_id);
CREATE INDEX idx_medics_time_medic_calendar_id ON medics_time_slots (medic_calendar_id);