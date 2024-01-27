package br.com.fiap.techchallenge.domain.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "dataHoraInicio")
    @JsonFormat(pattern = "dd/MM/yyyy HH'h':mm'm':ss's'")
    private LocalDateTime dataHoraInicio;

    @Column(name = "dataHoraFim")
    @JsonFormat(pattern = "dd/MM/yyyy HH'h':mm'm':ss's'")
    private LocalDateTime dataHoraFim;

    @Column(name = "atualizacoes")
    private int atualizacoes;

    
}
