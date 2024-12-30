package org.example.test.contorller;

import lombok.AllArgsConstructor;
import org.example.test.entities.Medecin;
import org.example.test.entities.Patient;
import org.example.test.entities.Rdv;
import org.example.test.service.IServiceMedecin;
import org.example.test.service.IServicePatient;
import org.example.test.service.IServiceRdv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rdv")
@AllArgsConstructor
public class RdvController {

    IServiceRdv serviceRdv;
    IServicePatient servicePatient;
    IServiceMedecin serviceMedecin;

    @GetMapping("")
    public List<Rdv> all() {
        return serviceRdv.findAllRdvs();
    }
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PostMapping("/add")
    public  ResponseEntity<Rdv>  add(@RequestBody Rdv rdv ) {
    serviceRdv.save(rdv);
        return ResponseEntity.status(HttpStatus.CREATED).body(rdv);

    }

    @GetMapping("/{id}")
    public Rdv getparid(int id) {
        return serviceRdv.findRdvById(id);
    }



    @DeleteMapping("/{id}")
    public String delete(int id) {
        serviceRdv.deleteRdv(id);
        return "Suppression réussite";
    }
}
