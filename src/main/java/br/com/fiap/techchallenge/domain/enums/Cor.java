package br.com.fiap.techchallenge.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

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

    public List<Cor> getCores(){
        return Arrays.stream(Cor.values()).toList();
    }
}
