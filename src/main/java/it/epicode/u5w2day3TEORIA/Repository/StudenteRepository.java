package it.epicode.u5w2day3TEORIA.Repository;

import it.epicode.u5w2day3TEORIA.Model.Studente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudenteRepository extends JpaRepository<Studente, Integer> {
}
