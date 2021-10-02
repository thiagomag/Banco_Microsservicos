package br.com.thiago.investimentos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SaldoInsuficienteParaInvestir extends RuntimeException{
    public SaldoInsuficienteParaInvestir() {
        super("Saldo insuficiente para realizar o seu investimento!");
    }
}
