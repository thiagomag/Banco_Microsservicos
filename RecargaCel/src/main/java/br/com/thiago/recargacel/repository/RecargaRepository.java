package br.com.thiago.recargacel.repository;

import br.com.thiago.recargacel.entity.Recarga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecargaRepository extends JpaRepository<Recarga, Long> {
}
