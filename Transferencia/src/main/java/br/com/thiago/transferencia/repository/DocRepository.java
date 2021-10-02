package br.com.thiago.transferencia.repository;

import br.com.thiago.transferencia.entity.Doc;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DocRepository extends MongoRepository<Doc, Long> {
}
