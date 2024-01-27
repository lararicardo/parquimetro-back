package br.com.fiap.techchallenge.domain.model;

import br.com.fiap.techchallenge.domain.enums.DataHora;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tempo {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "condutor")
    private Long condutor;

    @Column(name = "veiculo")
    private Long veiculo;

    @Column(name = "tempoRegistrado")
    private String tempoRegistrado;

    @Column(name = "dateTimeRegistrado")
    @JsonFormat(pattern = "dd/MM/yyyy HH'h':mm'm':ss's'")
    private LocalDateTime dateTimeRegistrado;

    @Column(name = "dataHoraInserido")
    @JsonFormat(pattern = "dd/MM/yyyy HH'h':mm'm':ss's'")
    private LocalDateTime dataHoraInserido;

    @Column(name = "dataHoraFinalizado")
    @JsonFormat(pattern = "dd/MM/yyyy HH'h':mm'm':ss's'")
    private LocalDateTime dataHoraFinalizado;

    @Column(name = "atualizacoes")
    private int atualizacoes;

}
