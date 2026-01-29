INSERT INTO users (email, "password", "role")
VALUES ('operator2@gmail.com', '$2a$12$VTk6T44XSxHwqg0wkSVaz.FWnVcTc5vbJz2y0xPt4Imd3ug2rzSrC', 'OPERATOR');

INSERT INTO operators ("name", surname, created_at, user_id)
SELECT 'Will', 'Doe', '2026-01-28', u.id
FROM users u
WHERE u.email = 'operator2@gmail.com';

INSERT INTO users (email, "password", "role")
VALUES ('medic2@gmail.com', '$2a$12$VTk6T44XSxHwqg0wkSVaz.FWnVcTc5vbJz2y0xPt4Imd3ug2rzSrC', 'MEDIC');

INSERT INTO medics ("name", surname, created_at, user_id, biography, license_number)
SELECT 'Chris', 'Doe', '2026-01-28', u.id, 'Bio', 'AIEFB44HZ'
FROM users u
WHERE u.email = 'medic2@gmail.com';