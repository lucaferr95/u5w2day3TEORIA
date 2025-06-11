package it.epicode.u5w2day3TEORIA.Model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiError {
    //i dati che vogliamo mostrare al client quando c'è un errore
    private String message;
    private LocalDateTime dataErrore;

}
