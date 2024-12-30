package org.example.test.service;

import lombok.AllArgsConstructor;
import org.example.test.entities.Medecin;
import org.example.test.entities.Patient;
import org.example.test.entities.Rdv;
import org.example.test.repository.MedecinRepository;
import org.example.test.repository.PatientRepository;
import org.example.test.repository.RdvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceRdv implements IServiceRdv {

    private RdvRepository repo;

    @Override
    public Rdv save(Rdv rdv) {

        return repo.save(rdv);
    }

    @Override
    public Rdv findRdvById(int id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Rdv> findAllRdvs() {
        return repo.findAll();
    }

    @Override
    public Rdv updateRdv(Rdv rdv) {
        return repo.save(rdv);
    }

    @Override
    public void deleteRdv(int id) {
repo.deleteById(id);
    }
}
