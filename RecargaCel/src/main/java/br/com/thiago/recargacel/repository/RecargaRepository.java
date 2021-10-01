package br.com.thiago.recargacel.repository;

import br.com.thiago.recargacel.entity.Recarga;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecargaRepository extends MongoRepository<Recarga, Long> {
}
