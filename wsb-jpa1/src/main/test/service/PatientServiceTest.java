package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.repository.PatientRepository;
import com.capgemini.wsb.repository.VisitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private VisitRepository visitRepository;

    private PatientEntity patient;

    @BeforeEach
    public void setUp() {
        patient = new PatientEntity();
        patient.setFirstName("John");
        patient.setLastName("Doe");
        patient.setTelephoneNumber("123456789");
        patient.setEmail("john.doe@example.com");
        patient.setPatientNumber("P123");
        patient.setDateOfBirth(LocalDate.of(1980, 1, 1));
        patient.setAge(40);
        patient.setRegisteredDate(LocalDate.of(2020, 1, 1));
        patient = patientRepository.save(patient);
    }

    @Test
    public void testGetPatientById() {
        // when
        PatientTO result = patientService.getPatientById(patient.getId());

        // then
        assertThat(result).isNotNull();
        assertThat(result.getFirstName()).isEqualTo("John");
        assertThat(result.getLastName()).isEqualTo("Doe");
        assertThat(result.getRegisteredDate()).isEqualTo("2020-01-01");
    }

    @Test
    public void testDeletePatient() {
        // given
        Long patientId = patient.getId();

        // when
        patientService.deletePatient(patientId);

        // then
        boolean exists = patientRepository.existsById(patientId);
        List<?> visits = visitRepository.findByPatientId(patientId);

        assertThat(exists).isFalse();
        assertThat(visits).isEmpty();
    }
}
