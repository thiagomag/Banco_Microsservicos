package br.com.thiago.transferencia.service;

import br.com.thiago.movimentacaoconta.config.MovimentacaoFeignClient;
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
    private final MovimentacaoFeignClient movimentacaoFeignClient;

    public ResponseEntity<Pix> realizarPix(PixDTO pixDTO) {
        if (movimentacaoConta(pixDTO)){
            var pix = PixDTO.convert(pixDTO);
            pixRepository.save(pix);
            return ResponseEntity.ok(pix);
        }
        return null;
    }

    public boolean movimentacaoConta(PixDTO pixDTO){
        return movimentacaoFeignClient.sacar(pixDTO.getValor(), pixDTO.getNumeroConta()) != null;
    }
}
