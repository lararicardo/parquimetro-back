package br.com.fiap.techchallenge.domain.repository;

import br.com.fiap.techchallenge.domain.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, String> {

}
