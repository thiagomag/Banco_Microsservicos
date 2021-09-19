package br.com.thiago.cadastrocliente.repository;

import br.com.thiago.cadastrocliente.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, String> {
}
