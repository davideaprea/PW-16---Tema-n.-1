CREATE TABLE patients (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,

    name VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL,

    created_at DATE NOT NULL DEFAULT CURRENT_DATE,

    user_id BIGINT UNIQUE,

    birth_date DATE NOT NULL,
    tax_id_code VARCHAR(16) NOT NULL UNIQUE,
    phone_number VARCHAR(20) NOT NULL,
    gender VARCHAR(10) NOT NULL,

    CONSTRAINT fk_patients_user_id
        FOREIGN KEY (user_id)
        REFERENCES users (id)
);
