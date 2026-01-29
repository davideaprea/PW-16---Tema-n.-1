INSERT INTO users (email, "password", "role")
VALUES ('user@gmail.com', '$2a$12$VTk6T44XSxHwqg0wkSVaz.FWnVcTc5vbJz2y0xPt4Imd3ug2rzSrC', 'USER');

INSERT INTO patients ("name", surname, created_at, user_id, birth_date, tax_id_code, phone_number, gender)
SELECT 'John', 'Doe', '2026-01-28', u.id, '2000-01-28', 'USRPTT99P15I483M', '2435972845', 'MALE'
FROM users u
WHERE u.email = 'user@gmail.com';

INSERT INTO users (email, "password", "role")
VALUES ('operator@gmail.com', '$2a$12$VTk6T44XSxHwqg0wkSVaz.FWnVcTc5vbJz2y0xPt4Imd3ug2rzSrC', 'OPERATOR');

INSERT INTO patients ("name", surname, created_at, user_id, birth_date, tax_id_code, phone_number, gender)
SELECT 'Will', 'Doe', '2026-01-28', u.id, '2000-01-28', 'USROPT99P15I483M', '2435972845', 'MALE'
FROM users u
WHERE u.email = 'operator@gmail.com';

INSERT INTO users (email, "password", "role")
VALUES ('medic@gmail.com', '$2a$12$VTk6T44XSxHwqg0wkSVaz.FWnVcTc5vbJz2y0xPt4Imd3ug2rzSrC', 'MEDIC');

INSERT INTO patients ("name", surname, created_at, user_id, birth_date, tax_id_code, phone_number, gender)
SELECT 'Chris', 'Doe', '2026-01-28', u.id, '2000-01-28', 'USRMED99P15I483M', '2435972845', 'MALE'
FROM users u
WHERE u.email = 'medic@gmail.com';