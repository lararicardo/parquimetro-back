package br.com.fiap.techchallenge.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum Cor {

    VERDE("Verde"),
    AMARELO("Amarelo"),
    BRANCO("Branco"),
    AZUL("Azul"),
    VERMELHO("Vermelho"),
    MARROM("Marrom"),
    ROSA("Rosa"),
    PRETO("Preto"),
    CINZA("Cinza"),
    LARANJA("Laranja"),
    PRATA("Prata");

    private final String nome;


    @JsonCreator
    public static Cor fromString(String value) {
        return Stream.of(Cor.values())
                .filter(enumValue -> enumValue.getNome().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
