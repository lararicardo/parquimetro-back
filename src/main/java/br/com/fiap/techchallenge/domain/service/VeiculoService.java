package br.com.fiap.techchallenge.domain.service;

import br.com.fiap.techchallenge.domain.model.Veiculo;
import br.com.fiap.techchallenge.domain.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> getAllVeiculos(){
        return veiculoRepository.findAll();
    }

    public Veiculo getVeiculoPorPlaca(String placa){
        return veiculoRepository
                .findById(placa)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veículo não encontrado"));
    }

    public Veiculo add(Veiculo veiculo) {
        if (veiculoRepository.findById(veiculo.getPlaca()).isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Veículo já existe na base de dados");
        }else{
            return veiculoRepository.save(veiculo);
        }
    }

    public Veiculo update(Veiculo veiculo){
        if (veiculoRepository.findById(veiculo.getPlaca()).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Veículo não encontrado");
        }else{
            return veiculoRepository.save(veiculo);
        }
    }

    public void delete(String placa) {
        var veiculo = veiculoRepository.findById(placa);
        if (veiculo.isPresent()){
            veiculoRepository.delete(veiculo.get());
        }else{
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Veículo não existe na base de dados");
        }
    }
}
