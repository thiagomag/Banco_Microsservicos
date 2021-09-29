package br.com.thiago.recargacel.dto;

import br.com.thiago.recargacel.entity.Operadora;
import br.com.thiago.recargacel.entity.Recarga;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RecargaDTO {
    private String numeroCel;
    private Operadora operadora;
    private BigDecimal valor;

    public static Recarga convert(RecargaDTO recargaDTO){
        Recarga recarga = new Recarga();
        recarga.setNumeroCel(recargaDTO.numeroCel);
        recarga.setOperadora(recargaDTO.getOperadora());
        recarga.setValor(recargaDTO.getValor());
        return recarga;
    }
}
