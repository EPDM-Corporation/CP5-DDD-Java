package br.com.fiap2espa.cp4.controller;

import br.com.fiap2espa.cp4.domain.model.Atendente;
import br.com.fiap2espa.cp4.service.AtendenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atendentes")
@RequiredArgsConstructor
public class AtendenteController {

    private final AtendenteService atendenteService;

    @PostMapping
    public ResponseEntity<Atendente> cadastrar(@RequestBody Atendente atendente) {
        return ResponseEntity.ok(atendenteService.salvar(atendente));
    }

    @GetMapping
    public ResponseEntity<List<Atendente>> listar() {
        return ResponseEntity.ok(atendenteService.listar());
    }
}