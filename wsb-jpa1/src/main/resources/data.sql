INSERT INTO Address (city, address_line_1, address_line_2, postal_code) VALUES ('City1', 'AddressLine1_1', 'AddressLine2_1', '62-030');
INSERT INTO Address (city, address_line_1, address_line_2, postal_code) VALUES ('City2', 'AddressLine1_2', 'AddressLine2_2', 'PostalCode2');

INSERT INTO Doctor (first_name, last_name, telephone_number, email, doctor_number, specialization, address_id) VALUES ('John', 'Doe', '123456789', 'john.doe@example.com', 'D123', 'SURGEON', 1);
INSERT INTO Doctor (first_name, last_name, telephone_number, email, doctor_number, specialization, address_id) VALUES ('Jane', 'Smith', '987654321', 'jane.smith@example.com', 'D456', 'DERMATOLOGIST', 2);

INSERT INTO Patient (first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id, age, registered_date) VALUES ('Alice', 'Johnson', '111111111', 'alice.johnson@example.com', 'P123', '1980-01-01', 1, 42, '2020-01-01');
INSERT INTO Patient (first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id, age, registered_date) VALUES ('Bob', 'Brown', '222222222', 'bob.brown@example.com', 'P456', '1990-02-02', 2, 32, '2021-01-01');

INSERT INTO medical_treatment (id, description, type) VALUES (1, 'Surgery for heart', 'USG');
INSERT INTO medical_treatment (id, description, type) VALUES (2, 'Therapy for brain', 'EKG');

INSERT INTO Visit (description, time, doctor_id, patient_id, treatment_id) VALUES ('Checkup', '2023-01-01 10:00:00', 1, 1, 1);
INSERT INTO Visit (description, time, doctor_id, patient_id, treatment_id) VALUES ('Consultation', '2023-01-02 11:00:00', 2, 2, 2);
INSERT INTO Visit (description, time, doctor_id, patient_id, treatment_id) VALUES ('Follow-up', '2023-02-01 10:00:00', 1, 1, 1);
INSERT INTO Visit (description, time, doctor_id, patient_id, treatment_id) VALUES ('Therapy Session', '2023-03-01 10:00:00', 2, 2, 2);



