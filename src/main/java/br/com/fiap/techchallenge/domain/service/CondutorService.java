package br.com.fiap.techchallenge.domain.service;

import br.com.fiap.techchallenge.domain.model.Condutor;
import br.com.fiap.techchallenge.domain.repository.CondutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CondutorService {

    @Autowired
    private CondutorRepository condutorRepository;

    public List<Condutor> getAll(){
        return condutorRepository.findAll();
    }

    public Condutor add(Condutor condutor) {
        return condutorRepository.save(condutor);
    }

    public Condutor update(Condutor condutor, Long id){
        if (condutorRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Condutor não encontrado");
        }else{
            return condutorRepository.save(condutor);
        }
    }

    public void delete(Long id) {
        var condutor = condutorRepository.findById(id);
        if (condutor.isPresent()){
            condutorRepository.delete(condutor.get());
        }else{
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Condutor não existe na base de dados");
        }
    }

    public List<Condutor> getCondutorByNomeCompleto(String nomeCompleto){
        return condutorRepository.findByNomeCompletoIgnoreCaseContaining(nomeCompleto);
    }

    public void saveAll(List<Condutor> lista){
        condutorRepository.saveAll(lista);
    }
}
