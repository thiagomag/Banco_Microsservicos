package br.com.thiago.transferencia.service;

import br.com.thiago.transferencia.dto.PixDTO;
import br.com.thiago.transferencia.entity.Pix;
import br.com.thiago.transferencia.repository.PixRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PixService {
    private final PixRepository pixRepository;

    public ResponseEntity<Pix> realizarPix(PixDTO pixDTO) {
        var pix = PixDTO.convert(pixDTO);
        pixRepository.save(pix);
        return ResponseEntity.ok(pix);
    }

    public boolean movimentacaoConta(PixDTO pixDTO){
        return true;
    }
}
