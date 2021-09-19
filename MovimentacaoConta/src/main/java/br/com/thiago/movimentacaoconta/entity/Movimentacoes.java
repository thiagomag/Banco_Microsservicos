package br.com.thiago.movimentacaoconta.entity;

import br.com.thiago.movimentacaoconta.enuns.TipoMovimentacao;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Movimentacoes {

    @Id
    private String id;
    private String numeroConta;
    private BigDecimal valor;
    private String contaDestino;
    private LocalDateTime data;
    private TipoMovimentacao tipo;

}
