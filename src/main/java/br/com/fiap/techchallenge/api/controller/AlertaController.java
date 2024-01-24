package br.com.fiap.techchallenge.api.controller;

import br.com.fiap.techchallenge.domain.enums.DataHora;
import br.com.fiap.techchallenge.domain.model.Tempo;
import br.com.fiap.techchallenge.domain.repository.TempoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/alertas")
@CrossOrigin(origins = "http://localhost:4200")
public class AlertaController {

    private final TempoRepository tempoRepository;

    public AlertaController(TempoRepository tempoRepository) {
        this.tempoRepository = tempoRepository;
    }

    @GetMapping("/verificar")
    public ResponseEntity<String> verificarAlertas() {
        List<Tempo> tempos = tempoRepository.findAll();

        for (Tempo tempo : tempos) {
            new Thread(() -> verificarTempoAutomatico(tempo)).start();
        }

        return ResponseEntity.ok("Verificação concluída");
    }

    private void verificarTempoAutomatico(Tempo tempo) {

    }

}
