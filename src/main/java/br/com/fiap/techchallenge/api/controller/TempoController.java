package br.com.fiap.techchallenge.api.controller;

import br.com.fiap.techchallenge.api.model.ControleTempoDTO;
import br.com.fiap.techchallenge.api.model.TempoDTO;
import br.com.fiap.techchallenge.domain.enums.DataHora;
import br.com.fiap.techchallenge.domain.model.Tempo;
import br.com.fiap.techchallenge.domain.service.TempoService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/tempos")
@CrossOrigin(origins = "http://localhost:4200")
public class TempoController {

    @Autowired
    private TempoService tempoService;

    @GetMapping
    public List<Tempo> getAll() {
        return tempoService.getAll();
    }

    @GetMapping("/cadastro")
    public List<ControleTempoDTO> getListaDeTempos() {
        return Arrays.asList(
                new ControleTempoDTO(DataHora.AUTOMATICO.getName(), DataHora.AUTOMATICO.getFormatter().toString(), DataHora.AUTOMATICO.getValue(), null),
                new ControleTempoDTO(DataHora.HORA_1.getName(), DataHora.HORA_1.getFormatter().toString(), DataHora.HORA_1.getValue(), DataHora.HORA_1.getHora()),
                new ControleTempoDTO(DataHora.HORA_2.getName(), DataHora.HORA_2.getFormatter().toString(), DataHora.HORA_2.getValue(), DataHora.HORA_2.getHora()),
                new ControleTempoDTO(DataHora.HORA_3.getName(), DataHora.HORA_3.getFormatter().toString(), DataHora.HORA_3.getValue(), DataHora.HORA_3.getHora()),
                new ControleTempoDTO(DataHora.HORA_4.getName(), DataHora.HORA_4.getFormatter().toString(), DataHora.HORA_4.getValue(), DataHora.HORA_4.getHora())
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tempo add(@RequestBody @NotNull Tempo tempo) {
        return tempoService.add(tempo);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Tempo update(@RequestBody @NotNull Tempo tempo, @PathVariable("id") Long id){
        return tempoService.update(tempo, id);
    }

}
