package br.com.thiago.investimentos.repository;

import br.com.thiago.investimentos.entity.Investimento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestimentoRepository extends MongoRepository<Investimento, String> {

    Iterable<Investimento> findByNumeroConta(String numeroConta);
}
