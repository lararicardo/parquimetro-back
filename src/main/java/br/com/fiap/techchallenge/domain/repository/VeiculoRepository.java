package br.com.fiap.techchallenge.domain.repository;

import br.com.fiap.techchallenge.domain.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    List<Veiculo> findByPlacaIgnoreCaseContaining(String placa);

    Optional<Veiculo> findByPlaca(String placa);
}
