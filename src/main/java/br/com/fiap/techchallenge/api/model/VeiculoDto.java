package br.com.fiap.techchallenge.api.model;

import br.com.fiap.techchallenge.domain.enums.Cor;
import br.com.fiap.techchallenge.domain.model.Veiculo;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class VeiculoDto {

    private Long id;

    private String placa;

    private String marca;

    private String modelo;

    private Cor cor;

    private String anoFabricacao;

    private String anoModelo;

    public Veiculo toEntity(){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, Veiculo.class);
    }
}
