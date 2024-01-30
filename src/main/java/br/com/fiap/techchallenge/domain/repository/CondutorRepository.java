package br.com.fiap.techchallenge.domain.repository;

import br.com.fiap.techchallenge.domain.model.Condutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CondutorRepository extends JpaRepository<Condutor, Long> {

    List<Condutor> findByNomeCompletoIgnoreCaseContaining(String nomeCompleto);
}
