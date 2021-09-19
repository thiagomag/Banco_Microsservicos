package br.com.thiago.cadastrocliente.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private List<EnderecoDto> enderecoDtoList;
}
