package br.com.thiago.cadastrocontacorrente.controller;

import br.com.thiago.cadastrocontacorrente.dto.ContaCorrenteDTO;
import br.com.thiago.cadastrocontacorrente.entity.ContaCorrente;
import br.com.thiago.cadastrocontacorrente.service.ContaCorrenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contaCorrente")
public class ContaCorrenteController {

    private final ContaCorrenteService contaCorrenteService;

    @PostMapping("/adicionarConta")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ContaCorrente> adicionarConta(@RequestBody ContaCorrenteDTO contaCorrenteDTO) {
        return contaCorrenteService.adicionarConta(contaCorrenteDTO);
    }

    @PostMapping("/sacar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ContaCorrente> sacar(@RequestBody ContaCorrenteDTO contaCorrenteDTO) {
        return contaCorrenteService.adicionarConta(contaCorrenteDTO);
    }

    @PostMapping("/depositar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ContaCorrente> depositar(@RequestBody ContaCorrenteDTO contaCorrenteDTO) {
        return contaCorrenteService.adicionarConta(contaCorrenteDTO);
    }
}
