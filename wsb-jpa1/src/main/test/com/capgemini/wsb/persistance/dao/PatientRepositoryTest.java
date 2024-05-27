package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.repository.PatientRepository;
import com.capgemini.wsb.repository.VisitRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientRepositoryTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private VisitRepository visitRepository;

    @Transactional
    @Test
    public void testGetAllVisitsForPatient() {
        // given
        Long patientId = 1L; // Assuming this patient ID exists in the test data

        // when
        List<?> visits = visitRepository.findByPatientId(patientId);

        // then
        assertThat(visits).isNotEmpty();
    }

    @Transactional
    @Test
    public void testFindByVisitsCountGreaterThan() {
        // given
        int visitsCount = 1;

        // when
        List<PatientEntity> patients = patientRepository.findByVisitsCountGreaterThan(visitsCount);

        // then
        assertThat(patients).isNotEmpty();
    }

    @Transactional
    @Test
    public void testFindByRegisteredDateBefore() {
        // given
        LocalDate date = LocalDate.of(2021, 1, 1);

        // when
        List<PatientEntity> patients = patientRepository.findByRegisteredDateBefore(date);

        // then
        assertThat(patients).isNotEmpty();
        assertThat(patients.get(0).getFirstName()).isEqualTo("Alice"); // Assuming this data exists in the test data
    }
}
