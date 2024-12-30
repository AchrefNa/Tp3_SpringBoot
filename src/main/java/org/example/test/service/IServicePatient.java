package org.example.test.service;
import org.example.test.entities.Patient;

import java.util.List;

public interface IServicePatient {
    public Patient save(Patient patient);

    public Patient findPatientById(int id);


    public List<Patient> findAllPatients();
    public Patient updatePatient(Patient patient);
    public void deletePatient(int id);
}
