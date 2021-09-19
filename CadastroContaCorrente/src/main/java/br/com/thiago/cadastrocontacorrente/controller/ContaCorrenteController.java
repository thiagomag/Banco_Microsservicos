package br.com.thiago.cadastrocontacorrente.controller;

import br.com.thiago.cadastrocontacorrente.dto.ContaCorrenteDTO;
import br.com.thiago.cadastrocontacorrente.entity.ContaCorrente;
import br.com.thiago.cadastrocontacorrente.service.ContaCorrenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("contaCorrente")
public class ContaCorrenteController {

    private final ContaCorrenteService contaCorrenteService;

    @PostMapping("/adicionarConta")
    public ResponseEntity<ContaCorrente> adicionarConta(@RequestBody ContaCorrenteDTO contaCorrenteDTO) {
        return contaCorrenteService.adicionarConta(contaCorrenteDTO);
    }
}
