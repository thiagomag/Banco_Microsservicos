package br.com.thiago.investimentos.service;

import br.com.thiago.investimentos.dto.InvestimentoDTO;
import br.com.thiago.investimentos.entity.Investimento;
import br.com.thiago.investimentos.repository.InvestimentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class InvestimentoService {

    private final InvestimentoRepository repository;

    public Investimento armazenarInvestimento(InvestimentoDTO investimentoDTO) {
        var investimento = investimentoDTO.convert();
        return repository.save(investimento);
    }

    public Iterable<Investimento> listarInvestimentos(String numeroConta) {
        var investimentoIterable = repository.findByNumeroConta(numeroConta);
        investimentoIterable.forEach(investimento -> investimento.setValorInvestido(
                investimento.getValorInvestido().multiply(BigDecimal.valueOf(investimento.getRendimento()))));
        return investimentoIterable;
    }

    public BigDecimal retirarInvestimento(String id) {
        var investimentoOpt = repository.findById(id);
        if (investimentoOpt.isPresent()) {
            var investimento = investimentoOpt.get();
            repository.deleteById(id);
            return investimento.getValorInvestido();
        }
        return BigDecimal.valueOf(0);
    }
}
