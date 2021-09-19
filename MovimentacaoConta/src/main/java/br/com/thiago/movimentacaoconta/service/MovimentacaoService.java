package br.com.thiago.movimentacaoconta.service;

import br.com.thiago.movimentacaoconta.repository.MovimentacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class MovimentacaoService {

    private final MovimentacaoRepository movimentacaoRepository;

    public void depositar(String numeroConta, BigDecimal valorDeposito) {

    }
}
