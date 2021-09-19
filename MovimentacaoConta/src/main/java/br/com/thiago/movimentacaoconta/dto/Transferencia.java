package br.com.thiago.movimentacaoconta.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transferencia {

    private String numeroConta;
    private String contaDestino;
    private BigDecimal valor;
    private LocalDateTime data;
}
