package br.com.fiap.techchallenge.domain.service;

import br.com.fiap.techchallenge.api.model.ControleTempoDTO;
import br.com.fiap.techchallenge.domain.enums.DataHora;
import br.com.fiap.techchallenge.domain.model.Condutor;
import br.com.fiap.techchallenge.domain.model.Tempo;
import br.com.fiap.techchallenge.domain.model.Veiculo;
import br.com.fiap.techchallenge.domain.repository.CondutorRepository;
import br.com.fiap.techchallenge.domain.repository.TempoRepository;
import br.com.fiap.techchallenge.domain.repository.VeiculoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TempoService {
    @Autowired
    private CondutorRepository condutorRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private TempoRepository tempoRepository;

    public List<Tempo> getAll(){
        return tempoRepository.findAll();
    }

    public Tempo add(Tempo tempo) {
        return tempoRepository.save(tempo);
    }

    public Tempo update(Tempo tempo, Long id){
        if (tempoRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tempo não encontrado");
        }else{
            return tempoRepository.save(tempo);
        }
    }

    @PostConstruct
    private void criarDadosNoDB(){
        List<Tempo> tempos = new ArrayList<>();
        List<Veiculo> veiculos = veiculoRepository.findAll();
        List<Condutor> Condutores = condutorRepository.findAll();
        tempos.add(Tempo.builder()
                .condutor(Condutores)
                .veiculos(veiculos)
                .tempoRegistrado(DataHora.HORA_1)
                .build());
        tempoRepository.saveAll(tempos);
    }
}
