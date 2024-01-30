package br.com.fiap.techchallenge.api.model;

import br.com.fiap.techchallenge.domain.enums.DataHora;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
@Data
public class ControleTempoDTO {

    private String name;
    private String value;
    private String valuetwo;
    private String valuethree;
    private int atualiza;

    public ControleTempoDTO(String name) {
        this.name = name;
        this.value = DataHora.fromString(name);
    }
}
