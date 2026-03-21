package br.com.fiap2espa.cp4.controller;

import br.com.fiap2espa.cp4.domain.model.Cliente;
import br.com.fiap2espa.cp4.service.ClienteService; // Importação do Service correta
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor

public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok().body(clienteService.salvar(cliente));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        return ResponseEntity.ok(clienteService.listarTodos());
    }

    //Adicionar depois na classe ClienteService
//    @GetMapping("/{id}")
//    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
//        return ResponseEntity.ok(clienteService.buscar(id));
//    }

}
