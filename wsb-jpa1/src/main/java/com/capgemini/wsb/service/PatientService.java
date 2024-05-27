package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;

import java.util.List;

public interface PatientService {
    List<VisitTO> getAllVisitsByPatientId(Long patientId);

    PatientTO getPatientById(Long id);

    List<PatientTO> getAllPatients();

    PatientTO savePatient(PatientTO patientTO);

    void deletePatient(Long id);
}
