package br.com.thiago.recargacel.service;

import br.com.thiago.recargacel.dto.RecargaDTO;
import br.com.thiago.recargacel.entity.Recarga;
import br.com.thiago.recargacel.repository.RecargaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecargaService {
    private final RecargaRepository recargaRepository;

    public ResponseEntity<Recarga> realizarRecarga(RecargaDTO recargaDTO) {
        if (movimentacaoConta(recargaDTO)){
            var recarga = RecargaDTO.convert(recargaDTO);
            recargaRepository.save(recarga);
            return ResponseEntity.ok(recarga);
        }
        return null;
    }

    public boolean movimentacaoConta(RecargaDTO recargaDTO){
        return true;
    }
}
