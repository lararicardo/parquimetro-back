package br.com.fiap.techchallenge.domain.service;

import br.com.fiap.techchallenge.domain.enums.Cor;
import br.com.fiap.techchallenge.domain.model.Veiculo;
import br.com.fiap.techchallenge.domain.repository.VeiculoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> getAllVeiculos(){
        return veiculoRepository.findAll();
    }

    public Veiculo getVeiculoByPlaca(String placa){
        return veiculoRepository
                .findByPlaca(placa.toUpperCase())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veículo não encontrado"));
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

    @PostConstruct
    private void criarDadosNoDB(){
        List<Veiculo> veiculos = new ArrayList<>();
        veiculos.add(Veiculo.builder()
                .placa("QPA3D88")
                .marca("Volks")
                .modelo("Virtus")
                .anoFabricacao("2011")
                .anoModelo("2012")
                .cor(Cor.PRETO)
                .build());

        veiculos.add(Veiculo.builder()
                .placa("IED6C44")
                .marca("Ford")
                .modelo("Fiesta")
                .anoFabricacao("2022")
                .anoModelo("2023")
                .cor(Cor.AMARELO)
                .build());

        veiculos.add(Veiculo.builder()
                .placa("NUC7I02")
                .marca("Fiat")
                .modelo("Palio")
                .anoFabricacao("2015")
                .anoModelo("2015")
                .cor(Cor.VERMELHO)
                .build());

        veiculoRepository.saveAll(veiculos);
    }
}
