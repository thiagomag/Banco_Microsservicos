package br.com.thiago.transferencia.entity;

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
public class Doc {
    @Id
    private String numeroDoc;
    private String numeroConta;
    private String contaDestino;
    private Long agenciaDestino;
    private BigDecimal valor;
    private BigDecimal taxa = BigDecimal.valueOf(8.50);
}
