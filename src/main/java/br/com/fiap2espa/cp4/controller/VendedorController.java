package br.com.fiap2espa.cp4.controller;

import br.com.fiap2espa.cp4.domain.model.Vendedor;
import br.com.fiap2espa.cp4.service.VendedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendedores")
@RequiredArgsConstructor
public class VendedorController {

    private final VendedorService vendedorService;

    @PostMapping
    public ResponseEntity<Vendedor> cadastrar(@RequestBody Vendedor vendedor) {
        return ResponseEntity.ok(vendedorService.salvarVendedor(vendedor));
    }

    @GetMapping
    public ResponseEntity<List<Vendedor>> listar() {
        return ResponseEntity.ok(vendedorService.listarVendedores());
    }
}