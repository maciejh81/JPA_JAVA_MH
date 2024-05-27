package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;

public class VisitMapper {
    public static VisitTO toVisitTO(VisitEntity entity) {
        if (entity == null) {
            return null;
        }

        VisitTO to = new VisitTO();
        to.setId(entity.getId());
        to.setDescription(entity.getDescription());
        to.setTime(entity.getTime());
        to.setDoctor(DoctorMapper.toDoctorTO(entity.getDoctor()));
        to.setPatient(PatientMapper.toPatientTO(entity.getPatient()));

        return to;
    }

    public static VisitEntity toVisitEntity(VisitTO to) {
        if (to == null) {
            return null;
        }

        VisitEntity entity = new VisitEntity();
        entity.setId(to.getId());
        entity.setDescription(to.getDescription());
        entity.setTime(to.getTime());
        entity.setDoctor(DoctorMapper.toDoctorEntity(to.getDoctor()));
        entity.setPatient(PatientMapper.toPatientEntity(to.getPatient()));

        return entity;
    }
}
