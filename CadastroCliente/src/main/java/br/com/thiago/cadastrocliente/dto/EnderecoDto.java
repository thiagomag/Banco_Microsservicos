package br.com.thiago.cadastrocliente.dto;

import br.com.thiago.cadastrocliente.enuns.TipoEndereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDto {

    private String cep;
    private TipoEndereco tipoEndereco;
}
