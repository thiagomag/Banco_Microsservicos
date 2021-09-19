package br.com.thiago.cadastrocliente.repository;

import br.com.thiago.cadastrocliente.entity.ClientePF;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientePFRepository extends JpaRepository<ClientePF, String> {
}
