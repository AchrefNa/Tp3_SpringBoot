package org.example.test.service;

import org.example.test.entities.Patient;
import org.example.test.entities.Rdv;

import java.util.List;

public interface IServiceRdv {
    public Rdv save(Rdv rdv);

    public Rdv findRdvById(int id);


    public List<Rdv> findAllRdvs();
    public Rdv updateRdv(Rdv rdv);
    public void deleteRdv(int id);
}
