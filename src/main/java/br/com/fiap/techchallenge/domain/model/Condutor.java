package br.com.fiap.techchallenge.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Condutor {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 60)
    @NotNull(value = "O nome não foi preenchido")
    private String nomeCompleto;

    @Column(nullable = false, length = 60)
    @NotNull(value = "O email não foi preenchido")
    private String email;

    @Column(nullable = false, length = 20)
    @NotNull(value = "O CPF não foi preenchido")
    private String cpf;

    @Column(nullable = false, length = 20)
    @NotNull(value = "O Celular não foi preenchido")
    private String celular;

    @OneToMany
    private List<Veiculo> veiculos;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private final LocalDateTime dataCadastro = LocalDateTime.now();

}
