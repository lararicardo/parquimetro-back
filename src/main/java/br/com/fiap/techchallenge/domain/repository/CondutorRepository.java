package br.com.fiap.techchallenge.domain.repository;

import br.com.fiap.techchallenge.domain.model.Condutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CondutorRepository extends JpaRepository<Condutor, Long> {


}
