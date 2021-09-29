package br.com.thiago.transferencia.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Ted {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String numeroTed;
    private String numeroConta;
    private Long agencia;
    private BigDecimal valor;
    private BigDecimal taxa = BigDecimal.valueOf(8.50);
}
