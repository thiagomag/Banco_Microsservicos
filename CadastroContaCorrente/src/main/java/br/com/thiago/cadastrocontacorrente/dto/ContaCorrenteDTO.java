package br.com.thiago.cadastrocontacorrente.dto;

import br.com.thiago.cadastrocontacorrente.entity.ContaCorrente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Random;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContaCorrenteDTO {

    private Long agencia;
    private String idCliente;

    public static ContaCorrente convert(ContaCorrenteDTO contaCorrenteDTO) {
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setAgencia(contaCorrenteDTO.getAgencia());
        contaCorrente.setSaldo(new BigDecimal(0));
        contaCorrente.setIdCliente(contaCorrenteDTO.getIdCliente());
        contaCorrente.setNumeroConta(numeroContaComDigito());
        return contaCorrente;
    }

    private static String numeroContaComDigito() {
        var numeroConta = new Random().nextLong();
        var numeroParaDigito = numeroConta;
        long nono = numeroParaDigito/100000000;
        numeroParaDigito-= nono*100000000;
        long oitavo = numeroParaDigito/10000000;
        numeroParaDigito -= oitavo*10000000;
        long setimo = numeroParaDigito/1000000;
        numeroParaDigito -= setimo*1000000;
        long sexto = numeroParaDigito/100000;
        numeroParaDigito -= sexto*100000;
        long quinto = numeroParaDigito/10000;
        numeroParaDigito -= quinto*10000;
        long quarto = numeroParaDigito/1000;
        numeroParaDigito -= quarto*1000;
        long terceiro = numeroParaDigito/100;
        numeroParaDigito -= terceiro*100;
        long segundo = numeroParaDigito/10;
        numeroParaDigito -= segundo*10;
        long primeiro = numeroParaDigito;
        var soma = (nono*9) + (oitavo*8) + (setimo*7) + (sexto*6) + (quinto*5) + (quarto*4) + (terceiro*3) + (segundo*2) + primeiro;
        long resto = soma%11;
        long digito = 11 - resto;
        StringBuilder contaComDigito = new StringBuilder();
        if(digito == 10) {
            contaComDigito.append(numeroConta).append('-').append('x');
        } else if(digito == 11) {
            contaComDigito.append(numeroConta).append('-').append('0');
        } else {
            contaComDigito.append(numeroConta).append('-').append(digito);
        }
        return contaComDigito.toString();
    }
}
