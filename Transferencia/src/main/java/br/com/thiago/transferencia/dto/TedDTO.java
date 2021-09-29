package br.com.thiago.transferencia.dto;

import br.com.thiago.transferencia.entity.Ted;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TedDTO {
    private String numeroConta;
    private Long agencia;
    private BigDecimal valor;

    public static Ted convert(TedDTO tedDTO) {
        Ted ted = new Ted();
        ted.setNumeroConta(tedDTO.getNumeroConta());
        ted.setAgencia(tedDTO.getAgencia());
        ted.setValor(tedDTO.getValor());
        return ted;
    }
}
