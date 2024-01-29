package br.com.fiap.techchallenge.api.model;

import org.modelmapper.ModelMapper;

import br.com.fiap.techchallenge.domain.enums.FormaPagamento;
import br.com.fiap.techchallenge.domain.model.Pagamento;
import lombok.Data;

@Data
public class PagamentoDTO {
    
    private Long id;
    private FormaPagamento formaPagamento;
    private int tempoUtilizado;
    private int valorPago;

     public Pagamento toEntity(){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, Pagamento.class);
    }
}
