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
public class Pix {
    @Id
    private String numeroPix;
    private String numeroConta;
    private String chavePix;
    private BigDecimal valor;
}
