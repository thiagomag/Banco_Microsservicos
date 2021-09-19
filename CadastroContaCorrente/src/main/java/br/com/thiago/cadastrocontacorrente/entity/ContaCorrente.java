package br.com.thiago.cadastrocontacorrente.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ContaCorrente {

    @Id
    private String numeroConta;
    private Long agencia;
    private BigDecimal saldo;
    private String idCliente;
}