package br.com.thiago.movimentacaoconta.service;

import br.com.thiago.cadastrocontacorrente.entity.ContaCorrente;
import br.com.thiago.movimentacaoconta.config.MovimentacaoFeignClient;
import br.com.thiago.movimentacaoconta.entity.Movimentacoes;
import br.com.thiago.movimentacaoconta.enuns.TipoMovimentacao;
import br.com.thiago.movimentacaoconta.repository.MovimentacaoRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@Data
@RequiredArgsConstructor
public class MovimentacaoService {

    private final MovimentacaoFeignClient client;

    private final MovimentacaoRepository movimentacaoRepository;

    public void depositar(String numeroConta, BigDecimal valorDeposito) {
        LocalDateTime data = LocalDateTime.now();
        ContaCorrente conta = client.findByID(numeroConta);
        conta.setSaldo(conta.getSaldo().add(valorDeposito));
        client.depositar( valorDeposito, numeroConta);
        movimentacaoRepository.save(new Movimentacoes(numeroConta, valorDeposito, data, TipoMovimentacao.DEPOSITO));
    }

    public void sacar(String numeroConta, BigDecimal valorDeposito) {
        LocalDateTime data = LocalDateTime.now();
        ContaCorrente conta = client.findByID(numeroConta);
        conta.setSaldo(conta.getSaldo().subtract(valorDeposito));
        client.sacar( valorDeposito, numeroConta);
        movimentacaoRepository.save(new Movimentacoes(numeroConta, valorDeposito, data, TipoMovimentacao.SAQUE));
    }

    public void transferir(String numeroContaOrigem, String numeroContaDestino, BigDecimal valorDeposito) {
        LocalDateTime data = LocalDateTime.now();
        ContaCorrente origem = client.findByID(numeroContaOrigem);
        ContaCorrente destino = client.findByID(numeroContaDestino);
        origem.setSaldo(origem.getSaldo().subtract(valorDeposito));
        destino.setSaldo(destino.getSaldo().add(valorDeposito));
        movimentacaoRepository.save(new Movimentacoes(numeroContaOrigem, valorDeposito, data, TipoMovimentacao.TRANSFERENCIA));
    }

}
