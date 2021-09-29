package br.com.thiago.recargacel.entity;

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
public class Recarga {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String numeroRecarga;
    private String numeroCel;
    private Operadora operadora;
    private BigDecimal valor;

}
