package org.example.test.service;

import lombok.AllArgsConstructor;
import org.example.test.entities.Medecin;
import org.example.test.repository.MedecinRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceMedecin implements IServiceMedecin {

    private MedecinRepository medecinRepository;
    @Override
    public Medecin save(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public Medecin findMedecinById(int id) {
        return medecinRepository.findById(id).get();
    }

    @Override
    public List<Medecin> findAllMedecins() {
        return medecinRepository.findAll();
    }

    @Override
    public Medecin updateMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public void deleteMedecin(int id) {
        medecinRepository.deleteById(id);

    }
}
