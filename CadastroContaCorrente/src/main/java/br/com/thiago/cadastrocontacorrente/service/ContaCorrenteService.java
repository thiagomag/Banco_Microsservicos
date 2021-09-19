package br.com.thiago.cadastrocontacorrente.service;

import br.com.thiago.cadastrocontacorrente.dto.ContaCorrenteDTO;
import br.com.thiago.cadastrocontacorrente.entity.ContaCorrente;
import br.com.thiago.cadastrocontacorrente.repository.ContaCorrenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContaCorrenteService {

    private final ContaCorrenteRepository contaCorrenteRepository;

    public ResponseEntity<ContaCorrente> adicionarConta(ContaCorrenteDTO contaCorrenteDTO) {
        var contaCorrente = ContaCorrenteDTO.convert(contaCorrenteDTO);
        contaCorrenteRepository.save(contaCorrente);
        return ResponseEntity.ok(contaCorrente);
    }
}
