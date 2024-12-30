package org.example.test.repository;

import org.example.test.entities.Rdv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RdvRepository extends JpaRepository<Rdv, Integer> {
}
