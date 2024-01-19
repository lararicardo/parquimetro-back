package br.com.fiap.techchallenge.api.model;

import lombok.Data;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
@Data
public class ControleTempoDTO {

    private String name;
    private String formatterPattern;
    private String automaticoValue;
    private LocalTime hora;

    public ControleTempoDTO(String name, String formatterPattern, String automaticoValue, LocalTime hora) {
        this.name = name;
        this.formatterPattern = formatterPattern;
        this.automaticoValue = automaticoValue;
        this.hora = hora;
    }
}
