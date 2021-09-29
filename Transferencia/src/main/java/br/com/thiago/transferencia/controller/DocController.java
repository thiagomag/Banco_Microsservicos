package br.com.thiago.transferencia.controller;

import br.com.thiago.transferencia.dto.DocDTO;
import br.com.thiago.transferencia.entity.Doc;
import br.com.thiago.transferencia.service.DocService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("doc")
public class DocController {
    private final DocService docService;

    @PostMapping("/realizarDoc")
    public ResponseEntity<Doc> realizarDoc(@RequestBody DocDTO docDTO) {
        return docService.realizarDoc(docDTO);
    }
}
