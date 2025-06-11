package it.epicode.u5w2day3TEORIA.Dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudenteDto {
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private int universitaId;

}
