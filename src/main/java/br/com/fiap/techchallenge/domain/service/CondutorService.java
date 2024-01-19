package br.com.fiap.techchallenge.domain.service;

import br.com.fiap.techchallenge.domain.enums.Cor;
import br.com.fiap.techchallenge.domain.model.Condutor;
import br.com.fiap.techchallenge.domain.model.Veiculo;
import br.com.fiap.techchallenge.domain.repository.CondutorRepository;
import br.com.fiap.techchallenge.domain.repository.VeiculoRepository;
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

    @Autowired
    private VeiculoRepository veiculoRepository;

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

    @PostConstruct
    private void criarDadosNoDB() {
        List<Condutor> condutores = new ArrayList<>();
        List<Veiculo> veiculos = veiculoRepository.findAll();
        condutores.add(Condutor.builder()
                .nomeCompleto("Yvan Nobrega Navega")
                .email("Yvan@hotmail.com")
                .cpf("54746079110")
                .celular("(51) 98532-2172")
                .veiculos(veiculos)
                .build());

        condutores.add(Condutor.builder()
                .nomeCompleto("Nina Isabel Kamilly Caldeira")
                .email("nina_isabel_caldeira@valltech.com.br")
                .cpf("707.207.881-96")
                .celular("(98) 3910-2335")
                .veiculos(veiculos)
                .build());

        condutores.add(Condutor.builder()
                .nomeCompleto("Ian Osvaldo Cauê Corte Real")
                .email("ian.osvaldo.cortereal@officetectecnologia.com.br")
                .cpf("447.666.079-70")
                .celular("(96) 3516-1910")
                .veiculos(veiculos)
                .build());

        condutorRepository.saveAll(condutores);
    }
}
