package br.com.fiap.techchallenge.domain.repository;

import br.com.fiap.techchallenge.domain.model.Tempo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TempoRepository extends JpaRepository<Tempo, Long> {


}