package org.example.test.service;

import org.example.test.entities.Medecin;

import java.util.List;

public interface IServiceMedecin {
    public Medecin save(Medecin medecin);

    public Medecin findMedecinById(int id);


    public List<Medecin> findAllMedecins();
    public Medecin updateMedecin(Medecin medecin);
    public void deleteMedecin(int id);

}
