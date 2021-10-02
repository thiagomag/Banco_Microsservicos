package br.com.thiago.movimentacaoconta.repository;

import br.com.thiago.movimentacaoconta.entity.Movimentacoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacoes, String> {
}
