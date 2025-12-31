CREATE TABLE IF NOT EXISTS medical_care (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(255) NOT NULL UNIQUE,
    description VARCHAR(255) NOT NULL,
    duration_in_seconds BIGINT NOT NULL,
    department_id BIGINT NOT NULL,

    CONSTRAINT fk_department
        FOREIGN KEY (department_id)
        REFERENCES departments (id)
        ON DELETE CASCADE
);

CREATE INDEX idx_department_id ON medical_care (department_id);