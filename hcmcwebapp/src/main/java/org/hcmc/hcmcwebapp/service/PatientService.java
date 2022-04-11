package org.hcmc.hcmcwebapp.service;

import org.hcmc.hcmcwebapp.model.Patient;
import org.hcmc.hcmcwebapp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getPatients() {
        return patientRepository.findAll(Sort.by(Sort.Direction.ASC, "fullNames"));
    }

    public List<Patient> getElderlyPatients() {
        var list = patientRepository.findAll();
        return list.stream()
                .filter(Patient::isElderly)
                .collect(Collectors.toList());
    }
}
