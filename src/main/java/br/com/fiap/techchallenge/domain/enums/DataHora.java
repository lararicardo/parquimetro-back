package br.com.fiap.techchallenge.domain.enums;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import lombok.Getter;

@Getter
public enum DataHora {

    AUTOMATICO("Automático"),
    HORA_1("01:00 Hora"),
    HORA_2("02:00 Horas"),
    HORA_3("03:00 Horas"),
    HORA_4("04:00 Horas");


    private final String name;

    DataHora(String name) {
        this.name = name;
    }

    public static String fromString(String name) {

        // Obtém a data atual
        LocalDate dataAtual = LocalDate.now();

        // Format Escolhido
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH'h':mm'm':ss's'");


        // Define a data e hora de acordo com o parâmetro
        if ("Automático".equals(name)) {
            return LocalDateTime.of(dataAtual, LocalTime.of(1, 0)).format(formatter);
        } else if ("01:00 Hora".equals(name)) {
            return LocalDateTime.of(dataAtual, LocalTime.of(1, 0)).format(formatter);
        } else if ("02:00 Horas".equals(name)) {
            return LocalDateTime.of(dataAtual, LocalTime.of(2, 0)).format(formatter);
        } else if ("03:00 Horas".equals(name)) {
            return LocalDateTime.of(dataAtual, LocalTime.of(3, 0)).format(formatter);
        } else if ("04:00 Horas".equals(name)) {
            return LocalDateTime.of(dataAtual, LocalTime.of(4, 0)).format(formatter);
        } else {
            throw new IllegalArgumentException("No enum constant with name " + name);
        }
    }

}