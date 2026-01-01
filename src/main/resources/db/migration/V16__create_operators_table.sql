CREATE TABLE medics (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,

    name VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL,

    created_at DATE NOT NULL DEFAULT CURRENT_DATE,

    user_id BIGINT UNIQUE,

    CONSTRAINT fk_medics_user_id
        FOREIGN KEY (user_id)
        REFERENCES users (id)
);