package br.com.thiago.transferencia.repository;

import br.com.thiago.transferencia.entity.Ted;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TedRepository extends MongoRepository<Ted, Long> {
}
