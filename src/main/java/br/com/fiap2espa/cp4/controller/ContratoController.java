package br.com.fiap2espa.cp4.controller;

import br.com.fiap2espa.cp4.dto.ContratoRequestDTO;
import br.com.fiap2espa.cp4.dto.ContratoResponseDTO;
import br.com.fiap2espa.cp4.service.ContratoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contratos")
@RequiredArgsConstructor
public class ContratoController {

    private final ContratoService service;

    @PostMapping
    public ResponseEntity<ContratoResponseDTO> salvar(@RequestBody ContratoRequestDTO dto) {
        return ResponseEntity.ok(service.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<ContratoResponseDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratoResponseDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContratoResponseDTO> atualizar(@PathVariable Long id,
                                                         @RequestBody ContratoRequestDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}