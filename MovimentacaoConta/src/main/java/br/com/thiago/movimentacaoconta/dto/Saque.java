package br.com.thiago.movimentacaoconta.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Saque {

    private String numeroConta;
    private BigDecimal valor;
    private LocalDateTime data;
}
