package br.com.thiago.investimentos.dto;

import br.com.thiago.investimentos.entity.Investimento;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class InvestimentoDTO {

    private String numeroConta;
    private BigDecimal valorInvestido;
    private float rendimento;

    public Investimento convert() {
        return Investimento.builder()
                .id(UUID.randomUUID().toString())
                .numeroConta(this.numeroConta)
                .valorInvestido(this.valorInvestido)
                .rendimento(this.getRendimento())
                .build();
    }
}
