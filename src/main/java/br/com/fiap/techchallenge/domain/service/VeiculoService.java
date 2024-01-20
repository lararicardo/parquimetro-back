package br.com.fiap.techchallenge.domain.service;

import br.com.fiap.techchallenge.domain.model.Veiculo;
import br.com.fiap.techchallenge.domain.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> getAllVeiculos(){
        return veiculoRepository.findAll();
    }

    public List<Veiculo> getVeiculoByPlaca(String placa){
        return veiculoRepository.findByPlacaIgnoreCaseContaining(placa.toUpperCase());
    }

    public Veiculo add(Veiculo veiculo) {
        if (veiculoRepository.findByPlaca(veiculo.getPlaca()).isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Veículo já existe na base de dados");
        }else{
            return veiculoRepository.save(veiculo);
        }
    }

    public Veiculo update(Veiculo veiculo, Long id){
        if (veiculoRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Veículo não encontrado");
        }else{
            return veiculoRepository.save(veiculo);
        }
    }

    public void delete(Long id) {
        var veiculo = veiculoRepository.findById(id);
        if (veiculo.isPresent()){
            veiculoRepository.delete(veiculo.get());
        }else{
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Veículo não existe na base de dados");
        }
    }

    public void saveAll(List<Veiculo> lista){
        veiculoRepository.saveAll(lista);
    }
}
