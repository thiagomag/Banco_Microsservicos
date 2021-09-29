package br.com.thiago.transferencia.repository;

import br.com.thiago.transferencia.entity.Pix;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PixRepository extends JpaRepository<Pix, Long> {
}
