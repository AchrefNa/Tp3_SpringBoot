package org.example.test.service;

import lombok.AllArgsConstructor;
import org.example.test.entities.Patient;
import org.example.test.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicePatient implements  IServicePatient{

    private PatientRepository patientRepository;
    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient findPatientById(int id) {
        return patientRepository.findById(id).get();
    }

    @Override
    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(int id) {
patientRepository.deleteById(id);
    }
}
