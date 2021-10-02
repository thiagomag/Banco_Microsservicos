package br.com.thiago.investimentos.service;

import br.com.thiago.investimentos.dto.InvestimentoDTO;
import br.com.thiago.investimentos.entity.Investimento;
import br.com.thiago.investimentos.exception.InvestimentoNaoEncontrado;
import br.com.thiago.investimentos.exception.SaldoInsuficienteParaInvestir;
import br.com.thiago.investimentos.repository.InvestimentoRepository;
import br.com.thiago.movimentacaoconta.config.MovimentacaoFeignClient;
import com.microbank.sendemail.controller.SendEmailController;
import com.microbank.sendemail.entity.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class InvestimentoService {

    private final InvestimentoRepository repository;
    private final MovimentacaoFeignClient client;
    private final SendEmailController email;

    public Investimento armazenarInvestimento(InvestimentoDTO investimentoDTO) {
        var investimento = investimentoDTO.convert();
        var conta = client.findByID(investimento.getNumeroConta());
        if (investimento.getValorInvestido().compareTo(conta.getSaldo()) <= 0) {
            client.sacar(investimento.getValorInvestido(),investimento.getNumeroConta());
            enviarEmail(investimento, "Investimento realizado%n");
            return repository.save(investimento);
        }
        else throw new SaldoInsuficienteParaInvestir();
    }

    public Iterable<Investimento> listarInvestimentos(String numeroConta) {
        var investimentoIterable = repository.findByNumeroConta(numeroConta);
        investimentoIterable.forEach(investimento -> investimento.setValorInvestido(
                investimento.getValorInvestido().multiply(BigDecimal.valueOf(investimento.getRendimento()))));
        return investimentoIterable;
    }

    public String retirarInvestimento(String id) {
        var investimentoOpt = repository.findById(id);
        if (investimentoOpt.isPresent()) {
            var investimento = investimentoOpt.get();
            client.depositar(investimento.getValorInvestido(), investimento.getNumeroConta());
            investimento.setValorInvestido(BigDecimal.valueOf(0));
            repository.save(investimento);
            enviarEmail(investimento, "Investimento retirado%n");
            return "O valor do investimento foi depositado em sua conta";
        }
        else throw new InvestimentoNaoEncontrado();
    }

    private void enviarEmail(Investimento investimento, String subject) {
        //TODO Resgatar o email do cliente
        var emailObject = new Email("email do cliente aqui", subject,
                "Foi realizado a seguinte operação: "+subject+ investimento);
        email.sendEmail(emailObject);
    }
}
