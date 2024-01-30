package br.com.fiap.techchallenge.api.model;

import java.util.List;

import org.modelmapper.ModelMapper;

import br.com.fiap.techchallenge.domain.enums.FormaPagamento;
import br.com.fiap.techchallenge.domain.model.Condutor;
import br.com.fiap.techchallenge.domain.model.Pagamento;
import br.com.fiap.techchallenge.domain.model.Tempo;
import br.com.fiap.techchallenge.domain.model.Veiculo;
import lombok.Data;

@Data
public class PagamentoDTO {
    
    private Long id;
    private FormaPagamento formaPagamento;
    private int tempoUtilizado;
    private int valorPago;
    private List<Condutor> condutores;
    private List<Veiculo> veiculos;
    private List<Tempo> tempos;


     public Pagamento toEntity(){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, Pagamento.class);
    }
}
