package br.com.fiap.techchallenge.api.controller;

import br.com.fiap.techchallenge.api.model.VeiculoDto;
import br.com.fiap.techchallenge.domain.enums.Cor;
import br.com.fiap.techchallenge.domain.model.Veiculo;
import br.com.fiap.techchallenge.domain.service.VeiculoService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
@CrossOrigin(origins = "http://localhost:4200")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public List<Veiculo> getAllVeiculos() {
        return veiculoService.getAllVeiculos();
    }

    @GetMapping("/{placa}")
    public Veiculo getVeiculoByPlaca(@PathVariable String placa) {
        return veiculoService.getVeiculoByPlaca(placa);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo add(@RequestBody @NotNull VeiculoDto veiculoDto) {
         return veiculoService.add(veiculoDto.toEntity());
    }

    @PutMapping("/{id}")
    public Veiculo update(@RequestBody @NotNull VeiculoDto veiculoDto, @PathVariable("id") Long id){
        return veiculoService.update(veiculoDto.toEntity(), id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable("id") Long id){
        veiculoService.delete(id);
    }

    @GetMapping("/cores")
    public Cor[] getAllCores(){
        return Cor.values();
    }
}
