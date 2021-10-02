package br.com.thiago.investimentos.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Investimento {

    @Id
    private String id;
    private String numeroConta;
    private BigDecimal valorInvestido;
    private float rendimento;

}
