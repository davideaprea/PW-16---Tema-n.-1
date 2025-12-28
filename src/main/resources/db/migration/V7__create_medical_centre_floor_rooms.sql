CREATE TABLE IF NOT EXISTS medical_centre_floor_rooms (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,

    floor_id BIGINT NOT NULL,
    number INTEGER NOT NULL,

    CONSTRAINT fk_room_floor
        FOREIGN KEY (floor_id)
        REFERENCES medical_centre_floors (id)
        ON DELETE CASCADE,

    CONSTRAINT uk_floor_room
        UNIQUE (floor_id, number)
);

CREATE INDEX idx_room_floor
    ON medical_centre_floor_rooms (floor_id);