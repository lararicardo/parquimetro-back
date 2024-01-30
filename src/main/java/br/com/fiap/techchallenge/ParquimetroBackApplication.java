package br.com.fiap.techchallenge;

import br.com.fiap.techchallenge.domain.enums.Cor;
import br.com.fiap.techchallenge.domain.model.Condutor;
import br.com.fiap.techchallenge.domain.model.Veiculo;
import br.com.fiap.techchallenge.domain.repository.VeiculoRepository;
import br.com.fiap.techchallenge.domain.service.CondutorService;
import br.com.fiap.techchallenge.domain.service.VeiculoService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ParquimetroBackApplication {

	@Autowired
	private VeiculoService veiculoService;

	@Autowired
	private CondutorService condutorService;

	public static void main(String[] args) {
		SpringApplication.run(ParquimetroBackApplication.class, args);
	}

	@PostConstruct
	private void criarDadosNoDB(){
		List<Veiculo> lista1 = new ArrayList<>();
		List<Veiculo> lista2 = new ArrayList<>();
		List<Veiculo> lista3 = new ArrayList<>();


		lista1.add(Veiculo.builder()
				.placa("QPA3D88")
				.marca("Volks")
				.modelo("Virtus")
				.anoFabricacao("2011")
				.anoModelo("2012")
				.cor(Cor.PRETO)
				.build());

		lista2.add(Veiculo.builder()
				.placa("IED6C44")
				.marca("Ford")
				.modelo("Fiesta")
				.anoFabricacao("2022")
				.anoModelo("2023")
				.cor(Cor.AMARELO)
				.build());

		lista3.add(Veiculo.builder()
				.placa("NUC7I02")
				.marca("Fiat")
				.modelo("Palio")
				.anoFabricacao("2015")
				.anoModelo("2015")
				.cor(Cor.VERMELHO)
				.build());

		lista1.add(Veiculo.builder()
				.placa("LYH3E12")
				.marca("Volks")
				.modelo("Nivus")
				.anoFabricacao("2023")
				.anoModelo("2024")
				.cor(Cor.CINZA)
				.build());

		lista3.add(Veiculo.builder()
				.placa("CQW7O63")
				.marca("Toyota")
				.modelo("Toyota Cross")
				.anoFabricacao("2020")
				.anoModelo("2020")
				.cor(Cor.BRANCO)
				.build());

		List<Condutor> condutores = new ArrayList<>();
		condutores.add(Condutor.builder()
				.nomeCompleto("Ricardo Rafael Lara Gomes")
				.email("ricardolara123@gmail.com")
				.cpf("226.166.230-05")
				.celular("(15) 99611-3333")
				.veiculos(lista1)
				.build());

		condutores.add(Condutor.builder()
				.nomeCompleto("Fulano da Silva")
				.email("fulano.dasilva@gmail.com")
				.cpf("005.322.150-87")
				.celular("(15) 88622-3333")
				.veiculos(lista2)
				.build());

		veiculoService.saveAll(lista1);
		veiculoService.saveAll(lista2);
		veiculoService.saveAll(lista3);
		condutorService.saveAll(condutores);
	}

}
