package it.epicode.u5w2day3TEORIA.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Universita {
    @Id
    @GeneratedValue
    private int id;

    private String nome;
    private String citta;

    @JsonIgnore
    @OneToMany(mappedBy = "universita")
    private List<Studente> studenti;
}
