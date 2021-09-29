package br.com.thiago.transferencia.repository;

import br.com.thiago.transferencia.entity.Doc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocRepository extends JpaRepository<Doc, Long> {
}
