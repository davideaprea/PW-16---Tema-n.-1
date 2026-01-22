CREATE TABLE medical_examination_reports (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    document_link VARCHAR(500) NOT NULL,
    medical_examination_id BIGINT NOT NULL,

    CONSTRAINT fk_medical_examination_report_examination_id
        FOREIGN KEY (medical_examination_id)
        REFERENCES medical_examinations (id)
);

CREATE INDEX idx_medical_examinations_report_examination_id ON medical_examination_reports (medical_examination_id);