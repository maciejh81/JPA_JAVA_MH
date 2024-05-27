package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PatientMapper {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static PatientTO toPatientTO(PatientEntity patientEntity) {
        if (patientEntity == null) {
            return null;
        }

        PatientTO patientTO = new PatientTO();
        patientTO.setId(patientEntity.getId());
        patientTO.setFirstName(patientEntity.getFirstName());
        patientTO.setLastName(patientEntity.getLastName());
        patientTO.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientTO.setEmail(patientEntity.getEmail());
        patientTO.setPatientNumber(patientEntity.getPatientNumber());
        patientTO.setDateOfBirth(patientEntity.getDateOfBirth().format(DATE_FORMATTER));
        patientTO.setAge(patientEntity.getAge());
        patientTO.setRegisteredDate(patientEntity.getRegisteredDate().format(DATE_FORMATTER));
        return patientTO;
    }

    public static PatientEntity toPatientEntity(PatientTO patientTO) {
        if (patientTO == null) {
            return null;
        }

        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientTO.getId());
        patientEntity.setFirstName(patientTO.getFirstName());
        patientEntity.setLastName(patientTO.getLastName());
        patientEntity.setTelephoneNumber(patientTO.getTelephoneNumber());
        patientEntity.setEmail(patientTO.getEmail());
        patientEntity.setPatientNumber(patientTO.getPatientNumber());
        patientEntity.setDateOfBirth(LocalDate.parse(patientTO.getDateOfBirth(), DATE_FORMATTER));
        patientEntity.setAge(patientTO.getAge());
        patientEntity.setRegisteredDate(LocalDate.parse(patientTO.getRegisteredDate(), DATE_FORMATTER));
        return patientEntity;
    }
}
