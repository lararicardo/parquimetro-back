package br.com.fiap.techchallenge.domain.model;

import br.com.fiap.techchallenge.domain.enums.Cor;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Veiculo {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 10)
    @NotNull(value = "A Placa não foi preenchida")
    private String placa;

    @Column(nullable = false, length = 60)
    @NotNull(value = "A Marca não foi preenchida")
    private String marca;

    @Column(nullable = false, length = 150)
    @NotNull(value = "O Modelo não foi preenchido")
    private String modelo;

    @Column(nullable = false, length = 10)
    @NotNull(value = "A Cor não foi preenchida")
    private Cor cor;

    @Column(nullable = true, length = 4)
    private String anoFabricacao;

    @Column(nullable = true, length = 4)
    private String anoModelo;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private final LocalDateTime dataCadastro = LocalDateTime.now();

    @PrePersist
    public void prePersist() {
        this.setPlaca(this.getPlaca().toUpperCase());
    }

}
