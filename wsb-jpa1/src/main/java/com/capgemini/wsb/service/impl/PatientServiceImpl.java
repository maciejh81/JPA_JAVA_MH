package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.repository.PatientRepository;
import com.capgemini.wsb.repository.VisitRepository;
import com.capgemini.wsb.rest.exception.EntityNotFoundException;
import com.capgemini.wsb.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private VisitRepository visitRepository;

    @Override
    public List<VisitTO> getAllVisitsByPatientId(Long patientId) {
        return visitRepository.findByPatientId(patientId).stream()
                .map(VisitMapper::toVisitTO)
                .collect(Collectors.toList());
    }

    @Override
    public PatientTO getPatientById(Long id) {
        PatientEntity patientEntity = patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id " + id));
        return PatientMapper.toPatientTO(patientEntity);
    }

    @Override
    public List<PatientTO> getAllPatients() {
        return patientRepository.findAll().stream()
                .map(PatientMapper::toPatientTO)
                .collect(Collectors.toList());
    }

    @Override
    public PatientTO savePatient(PatientTO patientTO) {
        PatientEntity patientEntity = PatientMapper.toPatientEntity(patientTO);
        patientEntity = patientRepository.save(patientEntity);
        return PatientMapper.toPatientTO(patientEntity);
    }

    @Override
    public void deletePatient(Long id) {
        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Patient not found with id " + id);
        }
    }
}
