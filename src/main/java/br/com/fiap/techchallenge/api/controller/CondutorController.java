package br.com.fiap.techchallenge.api.controller;

import br.com.fiap.techchallenge.api.model.VeiculoDto;
import br.com.fiap.techchallenge.domain.enums.Cor;
import br.com.fiap.techchallenge.domain.model.Condutor;
import br.com.fiap.techchallenge.domain.model.Veiculo;
import br.com.fiap.techchallenge.domain.service.CondutorService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/condutores")
@CrossOrigin(origins = "http://localhost:4200")
public class CondutorController {

    @Autowired
    private CondutorService condutorService;

    @GetMapping
    public List<Condutor> getAll() {
        return condutorService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Condutor add(@RequestBody @NotNull Condutor condutor) {
         return condutorService.add(condutor);
    }

    @PutMapping("/{id}")
    public Condutor update(@RequestBody @NotNull Condutor condutor, @PathVariable("id") Long id){
        return condutorService.update(condutor, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable("id") Long id){
        condutorService.delete(id);
    }
}
