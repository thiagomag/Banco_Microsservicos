package br.com.thiago.cadastrocliente.dto;

import br.com.thiago.cadastrocliente.config.CepClient;
import br.com.thiago.cadastrocliente.entity.ClientePF;
import br.com.thiago.cadastrocliente.entity.ClientePJ;
import br.com.thiago.cadastrocliente.entity.Endereco;
import br.com.thiago.cadastrocliente.exception.CepNaoExisteException;
import br.com.thiago.cadastrocliente.repository.EnderecoRepository;

import java.util.ArrayList;
import java.util.List;


public class DtoConvert {

    private final EnderecoRepository enderecoRepository;

    public DtoConvert(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public ClientePF clientePfDtoToClientePfConverter(ClientePfDto clientePfDto) {
        List<Endereco> enderecosClientePf = new ArrayList<>();

        for(int i = 0; i < clientePfDto.getEnderecoDtoList().size(); i++) {
            var endereco = CepClient.buscarEndereco(clientePfDto.getEnderecoDtoList().get(i).getCep());
            if(endereco == null) {
                throw new CepNaoExisteException();
            }
            endereco.setTipoEndereco(clientePfDto.getEnderecoDtoList().get(i).getTipoEndereco());
            enderecoRepository.save(endereco);
            enderecosClientePf.add(endereco);
        }
        return getClientePF(clientePfDto, enderecosClientePf);
    }

    private static ClientePF getClientePF(ClientePfDto clientePfDto, List<Endereco> enderecosClientePf) {
        ClientePF clientePF = new ClientePF();
        clientePF.setCpf(clientePfDto.getCpf());
        clientePF.setNome(clientePfDto.getNome());
        clientePF.setEmail(clientePfDto.getEmail());
        clientePF.setDataNascimento(clientePfDto.getDataNascimento());
        clientePF.setEndereco(enderecosClientePf);
        return clientePF;
    }

    public ClientePJ clientePjDtoToClientePjConverter(ClientePjDto clientePjDto) {
        List<Endereco> enderecosClientePj = new ArrayList<>();

        for(int i = 0; i < clientePjDto.getEnderecoDtoList().size(); i++) {
            var endereco = CepClient.buscarEndereco(clientePjDto.getEnderecoDtoList().get(i).getCep());
            if(endereco == null) {
                throw new CepNaoExisteException();
            }
            endereco.setTipoEndereco(clientePjDto.getEnderecoDtoList().get(i).getTipoEndereco());
            enderecoRepository.save(endereco);
            enderecosClientePj.add(endereco);
        }

        return getClientePJ(clientePjDto, enderecosClientePj);
    }

    private static ClientePJ getClientePJ(ClientePjDto clientePjDto, List<Endereco> enderecosClientePj) {
        ClientePJ clientePJ = new ClientePJ();
        clientePJ.setCnpj(clientePjDto.getCnpj());
        clientePJ.setNome(clientePjDto.getNome());
        clientePJ.setEmail(clientePjDto.getEmail());
        clientePJ.setDataNascimento(clientePJ.getDataNascimento());
        clientePJ.setEndereco(enderecosClientePj);
        return clientePJ;
    }
}