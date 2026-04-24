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

    private final ClienteService service;

    @PostMapping
    public ResponseEntity<EntityModel<ClienteResponseDTO>> cadastrar(@RequestBody ClienteRequestDTO request) {
        ClienteResponseDTO dto = service.salvar(request);

        return ResponseEntity.ok(EntityModel.of(dto,
                linkTo(methodOn(ClienteController.class).buscar(dto.id())).withSelfRel()));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<ClienteResponseDTO>>> listar() {
        List<EntityModel<ClienteResponseDTO>> lista = service.listarTodos().stream()
                .map(dto -> EntityModel.of(dto,
                        linkTo(methodOn(ClienteController.class).buscar(dto.id())).withSelfRel()))
                .toList();

        return ResponseEntity.ok(CollectionModel.of(lista,
                linkTo(methodOn(ClienteController.class).listar()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ClienteResponseDTO>> buscar(@PathVariable Long id) {
        ClienteResponseDTO dto = service.buscar(id);

        return ResponseEntity.ok(EntityModel.of(dto,
                linkTo(methodOn(ClienteController.class).buscar(id)).withSelfRel(),
                linkTo(methodOn(ClienteController.class).listar()).withRel("lista")));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<ClienteResponseDTO>> atualizar(@PathVariable Long id,
                                                                     @RequestBody ClienteRequestDTO request) {
        ClienteResponseDTO dto = service.atualizar(id, request);

        return ResponseEntity.ok(EntityModel.of(dto,
                linkTo(methodOn(ClienteController.class).buscar(id)).withSelfRel()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}