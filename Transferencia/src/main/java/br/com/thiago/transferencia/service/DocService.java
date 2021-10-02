package br.com.thiago.transferencia.service;

import br.com.thiago.transferencia.dto.DocDTO;
import br.com.thiago.transferencia.entity.Doc;
import br.com.thiago.transferencia.repository.DocRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocService {
    private final DocRepository docRepository;

    public ResponseEntity<Doc> realizarDoc(DocDTO docDTO) {
        var doc = DocDTO.convert(docDTO);
        docRepository.save(doc);
        return ResponseEntity.ok(doc);
    }

    public boolean movimentacaoConta(DocDTO docDTO){
        return true;
    }
}
