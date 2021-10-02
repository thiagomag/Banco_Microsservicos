package br.com.thiago.movimentacaoconta.entity;

import br.com.thiago.movimentacaoconta.enuns.TipoMovimentacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movimentacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String numeroConta;
    private BigDecimal valor;
    private LocalDateTime data;
    private TipoMovimentacao tipo;

    public Movimentacoes(String numeroConta, BigDecimal valor, LocalDateTime data, TipoMovimentacao tipo){
        this.numeroConta = numeroConta;
        this.valor = valor;
        this.data = data;
        this.tipo = tipo;
    }

}
