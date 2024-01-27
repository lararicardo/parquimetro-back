 package br.com.fiap.techchallenge.api.controller;

import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.techchallenge.domain.enums.FormaPagamento;
import br.com.fiap.techchallenge.domain.model.Pagamento;
import br.com.fiap.techchallenge.domain.service.PagamentoService;

@RestController
@RequestMapping("api/pagamentos")
@CrossOrigin(origins = "http://localhost:4200")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping("/formaPagamento")
    public FormaPagamento[] getAllFormaPagamentos(){
        return FormaPagamento.values();
    }

    @GetMapping
    public List<Pagamento> getAllPagamentos() {
        return pagamentoService.getAllPagamentos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pagamento add(@RequestBody @NotNull Pagamento pagamento) {
        return pagamentoService.add(pagamento);
    }
     
}