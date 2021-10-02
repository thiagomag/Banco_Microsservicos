package br.com.thiago.movimentacaoconta.config;

import br.com.thiago.cadastrocontacorrente.entity.ContaCorrente;
import br.com.thiago.movimentacaoconta.entity.Movimentacoes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.math.BigDecimal;

@Component
@FeignClient(name = "cadastroContaCorrente", url = "localhost:8081", path = "/contaCorrente")
public interface MovimentacaoFeignClient {

    @PatchMapping("/deposito/{valor}")
    @ResponseStatus(HttpStatus.OK)
    Movimentacoes depositar(@PathVariable BigDecimal valor, String numeroConta);

    @PatchMapping("/scar/{valor}")
    @ResponseStatus(HttpStatus.OK)
    Movimentacoes sacar(@PathVariable BigDecimal valor, String numeroConta);

    @PatchMapping("/transferencia/{valor}/{numeroContaOrigem}/{numeroContaDestino}")
    @ResponseStatus(HttpStatus.OK)
    Movimentacoes transferencia(@PathVariable BigDecimal valor,
                                 @PathVariable String numeroContaOrigem,
                                 @PathVariable String numeroContaDestino);

    @GetMapping("/conta/{numeroConta}")
    @ResponseStatus(HttpStatus.OK)
    ContaCorrente findByID(@PathVariable String numeroConta);

}
