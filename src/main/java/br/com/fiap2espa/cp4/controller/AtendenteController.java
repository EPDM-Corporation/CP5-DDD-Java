package br.com.fiap2espa.cp4.controller;

import br.com.fiap2espa.cp4.dto.AtendenteRequestDTO;
import br.com.fiap2espa.cp4.dto.AtendenteResponseDTO;
import br.com.fiap2espa.cp4.service.AtendenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/atendentes")
@RequiredArgsConstructor
public class AtendenteController {

    private final AtendenteService service;

    @PostMapping
    public ResponseEntity<EntityModel<AtendenteResponseDTO>> cadastrar(@RequestBody AtendenteRequestDTO request) {
        AtendenteResponseDTO dto = service.salvar(request);

        return ResponseEntity.ok(EntityModel.of(dto,
                linkTo(methodOn(AtendenteController.class).buscar(dto.id())).withSelfRel(),
                linkTo(methodOn(AtendenteController.class).listar()).withRel("lista")));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<AtendenteResponseDTO>>> listar() {
        List<EntityModel<AtendenteResponseDTO>> lista = service.listar().stream()
                .map(dto -> EntityModel.of(dto,
                        linkTo(methodOn(AtendenteController.class).buscar(dto.id())).withSelfRel()))
                .toList();

        return ResponseEntity.ok(CollectionModel.of(lista,
                linkTo(methodOn(AtendenteController.class).listar()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<AtendenteResponseDTO>> buscar(@PathVariable Long id) {
        AtendenteResponseDTO dto = service.buscar(id);

        return ResponseEntity.ok(EntityModel.of(dto,
                linkTo(methodOn(AtendenteController.class).buscar(id)).withSelfRel(),
                linkTo(methodOn(AtendenteController.class).listar()).withRel("lista")));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<AtendenteResponseDTO>> atualizar(@PathVariable Long id,
                                                                       @RequestBody AtendenteRequestDTO request) {
        AtendenteResponseDTO dto = service.atualizar(id, request);

        return ResponseEntity.ok(EntityModel.of(dto,
                linkTo(methodOn(AtendenteController.class).buscar(id)).withSelfRel()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}