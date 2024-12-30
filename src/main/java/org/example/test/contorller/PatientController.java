package org.example.test.contorller;

import lombok.AllArgsConstructor;
import org.example.test.entities.Patient;
import org.example.test.entities.Rdv;
import org.example.test.service.IServicePatient;
import org.example.test.service.IServiceRdv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
@AllArgsConstructor
public class PatientController {

    IServicePatient servicePatient;

    @GetMapping("")
    public List<Patient> all() {
        return servicePatient.findAllPatients();
    }
@PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Integer> add(@RequestBody Patient patient ) {
        servicePatient.save(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(patient.getId());

    }

    @GetMapping("/{id}")
    public Patient getparid(int id) {
        return servicePatient.findPatientById(id);
    }



    @DeleteMapping("/{id}")
    public String delete(int id) {
        servicePatient.deletePatient(id);
        return "Suppression réussite";
    }
}
