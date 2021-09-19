package br.com.thiago.cadastrocliente.controller;

import br.com.thiago.cadastrocliente.dto.ClientePfDto;
import br.com.thiago.cadastrocliente.dto.ClientePjDto;
import br.com.thiago.cadastrocliente.entity.ClientePF;
import br.com.thiago.cadastrocliente.entity.ClientePJ;
import br.com.thiago.cadastrocliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
public class ClienteControler {

    private final ClienteService clienteService;

    @PostMapping("/clientePF")
    public ResponseEntity<ClientePF> adicionarClientePF(@RequestBody ClientePfDto clientePfDto) {
        return clienteService.adicionarClientePF(clientePfDto);
    }

    @PostMapping("/clientePJ")
    public ResponseEntity<ClientePJ> adicionarClientePJ(@RequestBody ClientePjDto clientePjDto) {
        return clienteService.adicionarClientePJ(clientePjDto);
    }

    @GetMapping("/buscarClientePF")
    public ResponseEntity<List<ClientePF>> buscarTodosClientesPF() {
        return clienteService.buscarTodosClientesPF();
    }

    @GetMapping("/buscarClientePJ")
    public ResponseEntity<List<ClientePJ>> buscarTodosClientesPJ() {
        return clienteService.buscarTodosClientesPJ();
    }

    @GetMapping("/buscarClientePF/{cpf}")
    public ResponseEntity<ClientePF> buscarClientePFPorCPF(@PathVariable String cpf) {
        return clienteService.buscarClientePFPorCPF(cpf);
    }

    @GetMapping("/buscarClientePJ/{cnpj}")
    public ResponseEntity<ClientePJ> buscarClientePJPorCNPJ(@PathVariable String cnpj) {
        return clienteService.buscarClientePJPorCNPJ(cnpj);
    }
}
