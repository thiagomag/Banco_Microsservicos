package br.com.thiago.investimentos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvestimentoNaoEncontrado extends RuntimeException {
    public InvestimentoNaoEncontrado() {
        super("Este investimento não encontrado na nossa base de dados.");
    }
}
