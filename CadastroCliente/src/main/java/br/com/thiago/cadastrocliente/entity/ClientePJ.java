package br.com.thiago.cadastrocliente.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class ClientePJ {

    @Id
    private String cnpj;
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    @ManyToMany
    private List<Endereco> endereco;
}