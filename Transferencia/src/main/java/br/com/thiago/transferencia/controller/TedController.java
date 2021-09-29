package br.com.thiago.transferencia.controller;

import br.com.thiago.transferencia.dto.TedDTO;
import br.com.thiago.transferencia.entity.Ted;
import br.com.thiago.transferencia.service.TedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("ted")
public class TedController {
    private final TedService tedService;

    @PostMapping("/realizarTed")
    public ResponseEntity<Ted> realizarTed(@RequestBody TedDTO tedDTO) {
        return tedService.realizarTed(tedDTO);
    }
}
