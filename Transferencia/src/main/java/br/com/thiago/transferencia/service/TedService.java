package br.com.thiago.transferencia.service;

import br.com.thiago.movimentacaoconta.config.MovimentacaoFeignClient;
import br.com.thiago.transferencia.dto.TedDTO;
import br.com.thiago.transferencia.entity.Ted;
import br.com.thiago.transferencia.repository.TedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TedService {
    private final TedRepository tedRepository;
    private final MovimentacaoFeignClient movimentacaoFeignClient;

    public ResponseEntity<Ted> realizarTed(TedDTO tedDTO) {
        if (movimentacaoConta(tedDTO)){
            var ted = TedDTO.convert(tedDTO);
            tedRepository.save(ted);
            return ResponseEntity.ok(ted);
        }
        return null;
    }

    public boolean movimentacaoConta(TedDTO tedDTO){
        return movimentacaoFeignClient.transferencia(tedDTO.getValor(), tedDTO.getNumeroConta(), tedDTO.getContaDestino()) != null;
    }
}
