package br.com.thiago.movimentacaoconta.repository;

import br.com.thiago.movimentacaoconta.entity.Movimentacoes;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovimentacaoRepository extends ReactiveMongoRepository<Movimentacoes, String> {
}
