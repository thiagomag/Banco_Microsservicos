package br.com.thiago.investimentos.controller;

import br.com.thiago.investimentos.dto.InvestimentoDTO;
import br.com.thiago.investimentos.entity.Investimento;
import br.com.thiago.investimentos.service.InvestimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/investimento")
public class InvestimentoConroller {

    private final InvestimentoService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Investimento> listarInvestimento(@RequestBody String numeroConta) {
        return service.listarInvestimentos(numeroConta);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Investimento investir(@RequestBody InvestimentoDTO investimento) {
        return service.armazenarInvestimento(investimento);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String retirarInvestimento(@RequestBody String id) {
        return service.retirarInvestimento(id);
    }
}
