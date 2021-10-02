package br.com.thiago.recargacel.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recarga {
    @Id
    private String numeroRecarga;
    private String numeroConta;
    private String numeroCel;
    private Operadora operadora;
    private BigDecimal valor;

}
