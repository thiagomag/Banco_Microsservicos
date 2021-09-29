package br.com.thiago.recargacel.controller;

import br.com.thiago.recargacel.dto.RecargaDTO;
import br.com.thiago.recargacel.entity.Recarga;
import br.com.thiago.recargacel.service.RecargaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("recarga")
public class RecargaController {
    private final RecargaService recargaService;

    @PostMapping("/celular")
    public ResponseEntity<Recarga> realizarRecarga(@RequestBody RecargaDTO recargaDTO) {
        return recargaService.realizarRecarga(recargaDTO);
    }
}
