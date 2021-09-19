package br.com.thiago.cadastrocliente.config;

import br.com.thiago.cadastrocliente.entity.Endereco;
import org.springframework.web.client.RestTemplate;

public class CepClient {

    public static Endereco buscarEndereco(String cep) {
        String resourceUrl = "https://viacep.com.br/ws/" + cep + "/json/";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(resourceUrl, Endereco.class);
    }
}
