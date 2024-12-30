package org.example.test.contorller;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.example.test.entities.Medecin;
import org.example.test.entities.Patient;
import org.example.test.service.IServiceMedecin;
import org.example.test.service.IServicePatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medecin")
@AllArgsConstructor
public class MedecinController {

    IServiceMedecin medecinService;

    @GetMapping("")
    @PreAuthorize("hasAnyAuthority()")
    public List<Medecin> all() {
        return medecinService.findAllMedecins();
    }
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Integer> add(@RequestBody Medecin medecin ) {
        medecinService.save(medecin);
        return ResponseEntity.status(HttpStatus.CREATED).body(medecin.getId());

    }

    @GetMapping("/{id}")
    public Medecin getparid(int id) {
        return medecinService.findMedecinById(id);
    }



    @DeleteMapping("/{id}")
    public String delete(int id) {
        medecinService.deleteMedecin(id);
        return "Suppression réussite";
    }
}
