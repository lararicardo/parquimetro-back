package br.com.fiap.techchallenge.api.model;

import br.com.fiap.techchallenge.domain.enums.DataHora;
import br.com.fiap.techchallenge.domain.model.Condutor;
import br.com.fiap.techchallenge.domain.model.Tempo;
import br.com.fiap.techchallenge.domain.model.Veiculo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
public class TempoDTO {

    private Long id;
    private List<Condutor> condutores;
    private List<Veiculo> veiculos;
    private final List<DataHora> tempoRegistrado;

    public Tempo toEntity(){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, Tempo.class);
    }
}
