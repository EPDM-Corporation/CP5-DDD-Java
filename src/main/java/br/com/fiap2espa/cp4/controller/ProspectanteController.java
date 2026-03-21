package br.com.fiap2espa.cp4.controller;

import br.com.fiap2espa.cp4.domain.model.Prospectante;
import br.com.fiap2espa.cp4.service.ProspectanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prospectos")
@RequiredArgsConstructor
public class ProspectanteController {

    private final ProspectanteService prospectanteService;

    @PostMapping
    public ResponseEntity<Prospectante> registrar(@RequestBody Prospectante prospectante) {
        return ResponseEntity.ok(prospectanteService.registrarInteresse(prospectante));
    }

    @GetMapping
    public ResponseEntity<List<Prospectante>> listar() {
        return ResponseEntity.ok(prospectanteService.listarProspectos());
    }

    @PostMapping("/{id}/converter")
    public ResponseEntity<Void> converterEmCliente(@PathVariable Long id) {
        prospectanteService.converterParaCliente(id);
        return ResponseEntity.noContent().build();
    }
}