package br.com.fiap.techchallenge.domain.model;

import br.com.fiap.techchallenge.domain.enums.DataHora;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tempo {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private List<Condutor> condutor;
    @OneToMany
    private List<Veiculo> veiculos;

    @Column
    @Enumerated(EnumType.STRING) // Adicione esta anotação
    private DataHora tempoRegistrado = DataHora.HORA_1;

}
