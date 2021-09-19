package br.com.thiago.cadastrocliente.service;

import  br.com.thiago.cadastrocliente.dto.ClientePfDto;
import br.com.thiago.cadastrocliente.dto.ClientePjDto;
import br.com.thiago.cadastrocliente.dto.DtoConvert;
import br.com.thiago.cadastrocliente.entity.ClientePF;
import br.com.thiago.cadastrocliente.entity.ClientePJ;
import br.com.thiago.cadastrocliente.exception.CNPJNaoExisteException;
import br.com.thiago.cadastrocliente.exception.CPFNaoExisteException;
import br.com.thiago.cadastrocliente.repository.ClientePFRepository;
import br.com.thiago.cadastrocliente.repository.ClientePJRepository;
import br.com.thiago.cadastrocliente.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClientePFRepository clientePFRepository;
    private final ClientePJRepository clientePJRepository;
    private final EnderecoRepository enderecoRepository;

    public ResponseEntity<ClientePF> adicionarClientePF(ClientePfDto clientePfDto) {
        var clientePF = new DtoConvert(enderecoRepository).clientePfDtoToClientePfConverter(clientePfDto);
        return ResponseEntity.ok(clientePFRepository.save(clientePF));
    }

    public ResponseEntity<ClientePJ> adicionarClientePJ(ClientePjDto clientePjDto) {
        var clientePJ = new DtoConvert(enderecoRepository).clientePjDtoToClientePjConverter(clientePjDto);
        return ResponseEntity.ok(clientePJRepository.save(clientePJ));
    }

    public ResponseEntity<List<ClientePF>> buscarTodosClientesPF() {
        var clientesPF = clientePFRepository.findAll();
        return ResponseEntity.ok(clientesPF);
    }

    public ResponseEntity<List<ClientePJ>> buscarTodosClientesPJ() {
        var clientesPJ = clientePJRepository.findAll();
        return ResponseEntity.ok(clientesPJ);
    }

    public ResponseEntity<ClientePF> buscarClientePFPorCPF(String cpf) {
        var clientePF = clientePFRepository.findById(cpf).orElseThrow(CPFNaoExisteException::new);
        return ResponseEntity.ok(clientePF);
    }

    public ResponseEntity<ClientePJ> buscarClientePJPorCNPJ(String cnpj) {
        var clientePJ = clientePJRepository.findById(cnpj).orElseThrow(CNPJNaoExisteException::new);
        return ResponseEntity.ok(clientePJ);
    }
}
