package br.com.thiago.transferencia.controller;

import br.com.thiago.transferencia.dto.PixDTO;
import br.com.thiago.transferencia.entity.Pix;
import br.com.thiago.transferencia.service.PixService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("pix")
public class PixController {
    private final PixService pixService;

    @PostMapping("/realizarPix")
    public ResponseEntity<Pix> realizarPix(@RequestBody PixDTO pixDTO) {
        return pixService.realizarPix(pixDTO);
    }
}
