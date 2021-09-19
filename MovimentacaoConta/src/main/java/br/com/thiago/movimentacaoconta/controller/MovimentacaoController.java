package br.com.thiago.movimentacaoconta.controller;

import br.com.thiago.movimentacaoconta.service.MovimentacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    private final MovimentacaoService movimentacaoService;

    @PostMapping("/deposito/{numeroConta}")
    private ResponseEntity<HttpStatus> depositar(@PathVariable String numeroConta, BigDecimal valorDeposito) {
        movimentacaoService.depositar(numeroConta, valorDeposito);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
