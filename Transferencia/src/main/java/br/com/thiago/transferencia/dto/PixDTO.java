package br.com.thiago.transferencia.dto;

import br.com.thiago.transferencia.entity.Pix;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PixDTO {
    private String chavePix;
    private BigDecimal valor;

    public static Pix convert(PixDTO pixDTO) {
        Pix pix = new Pix();
        pix.setChavePix(pixDTO.getChavePix());
        pix.setValor(pixDTO.getValor());
        return pix;
    }
}
