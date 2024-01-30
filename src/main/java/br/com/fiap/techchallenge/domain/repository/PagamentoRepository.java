package br.com.fiap.techchallenge.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.techchallenge.domain.model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{

    
} 