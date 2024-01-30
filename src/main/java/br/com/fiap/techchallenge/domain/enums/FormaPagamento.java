package br.com.fiap.techchallenge.domain.enums;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FormaPagamento {

    PIX ("Pix"),
    CARTAODECREDITO ("CartaoDeCredito"),
    CARTAODEDEBITO ("CartaoDeDebito");

    private final String nome;

    @JsonCreator
    public static FormaPagamento fromString(String value) {
        return Stream.of(FormaPagamento.values())
                .filter(enumValue -> enumValue.getNome().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
