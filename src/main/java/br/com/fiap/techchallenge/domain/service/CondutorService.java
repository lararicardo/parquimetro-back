package br.com.fiap.techchallenge.domain.service;

import br.com.fiap.techchallenge.domain.enums.Cor;
import br.com.fiap.techchallenge.domain.model.Condutor;
import br.com.fiap.techchallenge.domain.model.Veiculo;
import br.com.fiap.techchallenge.domain.repository.CondutorRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
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

    @PostConstruct()
    private void criarDadosNoDB(){
        List<Condutor> condutores = new ArrayList<>();
        condutores.add(Condutor.builder()
                .nomeCompleto("Ricardo Rafael Lara Gomes")
                .email("ricardolara123@gmail.com")
                .cpf("226.166.230-05")
                .celular("(15) 99611-3333")
                .build());

        condutores.add(Condutor.builder()
                .nomeCompleto("Fulano da Silva")
                .email("fulano.dasilva@gmail.com")
                .cpf("005.322.150-87")
                .celular("(15) 88622-3333")
                .build());

        condutorRepository.saveAll(condutores);
    }
}
