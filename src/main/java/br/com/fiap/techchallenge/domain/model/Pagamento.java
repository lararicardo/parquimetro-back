package br.com.fiap.techchallenge.domain.model;

import br.com.fiap.techchallenge.domain.enums.FormaPagamento;
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

    @Column(name = "tempoUtilizado")
    private Integer tempoUtilizado;

    @Column(name = "valorPago")
    private Double valorPago;

    @Column(name = "formaPagamento")
    private FormaPagamento formaPagamento;
    
    @Column(name = "condutor")
    private Long condutorId;

    @Column(name = "veiculo")
    private Long veiculoId;
    
    @Column(name = "tempo")
    private Long tempoId;
}