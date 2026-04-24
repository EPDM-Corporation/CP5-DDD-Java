package br.com.fiap2espa.cp4.controller;

import br.com.fiap2espa.cp4.dto.ClienteRequestDTO;
import br.com.fiap2espa.cp4.dto.ClienteResponseDTO;
import br.com.fiap2espa.cp4.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<EntityModel<ClienteResponseDTO>> cadastrar(@RequestBody ClienteRequestDTO request) {
        ClienteResponseDTO dto = clienteService.salvar(request);
        return ResponseEntity.ok(EntityModel.of(dto,
                linkTo(methodOn(ClienteController.class).buscarPorId(dto.id())).withSelfRel()));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<ClienteResponseDTO>>> listarTodos() {
        List<EntityModel<ClienteResponseDTO>> clientes = clienteService.listarTodos().stream()
                .map(dto -> EntityModel.of(dto,
                        linkTo(methodOn(ClienteController.class).buscarPorId(dto.id())).withSelfRel()))
                .toList();

        return ResponseEntity.ok(CollectionModel.of(clientes,
                linkTo(methodOn(ClienteController.class).listarTodos()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ClienteResponseDTO>> buscarPorId(@PathVariable Long id) {
        ClienteResponseDTO dto = clienteService.buscar(id);
        return ResponseEntity.ok(EntityModel.of(dto,
                linkTo(methodOn(ClienteController.class).buscarPorId(id)).withSelfRel(),
                linkTo(methodOn(ClienteController.class).listarTodos()).withRel("lista_clientes")));
    }
}