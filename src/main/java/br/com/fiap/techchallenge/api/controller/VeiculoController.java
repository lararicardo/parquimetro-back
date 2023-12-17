package br.com.fiap.techchallenge.api.controller;

import br.com.fiap.techchallenge.api.model.VeiculoDto;
import br.com.fiap.techchallenge.domain.model.Veiculo;
import br.com.fiap.techchallenge.domain.service.VeiculoService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public List<Veiculo> getAllVeiculos() {
        return veiculoService.getAllVeiculos();
    }

    @GetMapping("/{placa}")
    public Veiculo getVeiculoPorPlaca(@PathVariable("placa") String placa) {
        return veiculoService.getVeiculoPorPlaca(placa);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo add(@RequestBody @NotNull VeiculoDto veiculoDto) {
         return veiculoService.add(veiculoDto.toEntity());
    }

    @PutMapping("/{placa}")
    public Veiculo update(@RequestBody @NotNull VeiculoDto veiculoDto, @PathVariable("placa") String placa){
        return veiculoService.update(veiculoDto.toEntity());
    }

    @DeleteMapping("/{placa}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable("placa") String placa){
        veiculoService.delete(placa);
    }

}
