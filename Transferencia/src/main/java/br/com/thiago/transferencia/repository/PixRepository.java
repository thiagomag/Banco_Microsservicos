package br.com.thiago.transferencia.repository;

import br.com.thiago.transferencia.entity.Pix;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PixRepository extends MongoRepository<Pix, Long> {
}
