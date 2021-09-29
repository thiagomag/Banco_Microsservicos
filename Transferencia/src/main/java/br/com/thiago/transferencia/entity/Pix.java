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
public class Pix {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String numeroPix;
    private String chavePix;
    private BigDecimal valor;
}
