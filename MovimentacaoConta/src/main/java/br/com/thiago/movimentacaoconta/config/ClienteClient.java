package br.com.thiago.movimentacaoconta.config;

import br.com.thiago.cadastrocliente.entity.ClientePF;
import br.com.thiago.cadastrocliente.entity.ClientePJ;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("cliente-service")
public interface ClienteClient {

    @GetMapping("/buscarClientePF/{cpf}")
    ClientePF getClientePF(@PathVariable String cpf);

    @GetMapping("/buscarClientePJ/{cnpj}")
    ClientePJ getClientePJ(@PathVariable String cnpj);
}
