package br.com.fiap.techchallenge.domain.repository;

import br.com.fiap.techchallenge.domain.model.Condutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CondutorRepository extends JpaRepository<Condutor, Long> {

    List<Condutor> findByNomeCompletoIgnoreCaseContaining(String nomeCompleto);
}
