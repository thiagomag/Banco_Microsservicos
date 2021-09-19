package br.com.thiago.cadastrocontacorrente.repository;

import br.com.thiago.cadastrocontacorrente.entity.ContaCorrente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long> {
}
