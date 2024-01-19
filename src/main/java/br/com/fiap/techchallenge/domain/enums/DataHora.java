package br.com.fiap.techchallenge.domain.enums;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DataHora {

    AUTOMATICO("dd/MM/yyyy HH:mm:ss", "Automático", LocalTime.now()),
    HORA_1("dd/MM/yyyy HH:mm:ss", "01:00 Hora", LocalTime.of(1, 0)),
    HORA_2("dd/MM/yyyy HH:mm:ss", "02:00 Horas", LocalTime.of(2, 0)),
    HORA_3("dd/MM/yyyy HH:mm:ss", "03:00 Horas", LocalTime.of(3, 0)),
    HORA_4("dd/MM/yyyy HH:mm:ss", "04:00 Horas", LocalTime.of(4, 0));

    private final DateTimeFormatter formatter;
    private final String name;
    private LocalTime hora;
    private final String value;

    DataHora(String pattern, String name, LocalTime hora) {
        this.formatter = DateTimeFormatter.ofPattern(pattern);
        this.name = name;
        this.hora = hora;
        this.value = null;
    }

    // Construtor adicional para AUTOMATICO
    DataHora(String pattern, String name, String automatico) {
        this.name = name;
        this.hora = LocalTime.parse("00:00:00", DateTimeFormatter.ofPattern("HH:mm:ss"));
        this.formatter = DateTimeFormatter.ofPattern(pattern);

        // Define a data e hora de acordo com o parâmetro 'automatico'
        if ("Automático".equals(automatico)) {
            this.value = LocalDateTime.now().format(formatter);
        } else if ("01:00 Hora".equals(automatico)) {
            this.value = String.valueOf(LocalTime.of(1, 0));
        } else if ("02:00 Horas".equals(automatico)) {
            this.value = String.valueOf(LocalTime.of(2, 0));
        } else if ("03:00 Horas".equals(automatico)) {
            this.value = String.valueOf(LocalTime.of(3, 0));
        } else if ("04:00 Horas".equals(automatico)) {
            this.value = String.valueOf(LocalTime.of(4, 0));;
        } else {
            this.value = null;
        }
    }
}