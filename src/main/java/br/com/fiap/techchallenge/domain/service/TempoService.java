package br.com.fiap.techchallenge.domain.service;

import br.com.fiap.techchallenge.domain.model.Tempo;
import br.com.fiap.techchallenge.domain.repository.CondutorRepository;
import br.com.fiap.techchallenge.domain.repository.TempoRepository;
import br.com.fiap.techchallenge.domain.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

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

    public Optional<Tempo> getTempoById(Long id){
        return tempoRepository.findById(id);
    }

}
