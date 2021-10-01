package br.com.thiago.transferencia.dto;

import br.com.thiago.transferencia.entity.Doc;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DocDTO {
    private String numeroConta;
    private String contaDestino;
    private Long agenciaDestino;
    private BigDecimal valor;

    public static Doc convert(DocDTO docDTO) {
        Doc doc = new Doc();
        doc.setNumeroConta(docDTO.getNumeroConta());
        doc.setContaDestino(docDTO.getContaDestino());
        doc.setAgenciaDestino(docDTO.getAgenciaDestino());
        doc.setValor(docDTO.getValor());
        return doc;
    }
}
