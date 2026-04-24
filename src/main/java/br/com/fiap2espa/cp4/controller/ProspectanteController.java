package br.com.fiap2espa.cp4.controller;

import br.com.fiap2espa.cp4.dto.*;
import br.com.fiap2espa.cp4.service.ProspectanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/prospectos")
@RequiredArgsConstructor
public class ProspectanteController {

    private final ProspectanteService service;

    @PostMapping
    public ResponseEntity<EntityModel<ProspectanteResponseDTO>> cadastrar(@RequestBody ProspectanteRequestDTO request) {
        ProspectanteResponseDTO dto = service.salvar(request);

        return ResponseEntity.ok(EntityModel.of(dto,
                linkTo(methodOn(ProspectanteController.class).buscar(dto.id())).withSelfRel()));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<ProspectanteResponseDTO>>> listar() {
        List<EntityModel<ProspectanteResponseDTO>> lista = service.listar().stream()
                .map(dto -> EntityModel.of(dto,
                        linkTo(methodOn(ProspectanteController.class).buscar(dto.id())).withSelfRel()))
                .toList();

        return ResponseEntity.ok(CollectionModel.of(lista,
                linkTo(methodOn(ProspectanteController.class).listar()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ProspectanteResponseDTO>> buscar(@PathVariable Long id) {
        ProspectanteResponseDTO dto = service.buscar(id);

        return ResponseEntity.ok(EntityModel.of(dto,
                linkTo(methodOn(ProspectanteController.class).buscar(id)).withSelfRel()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<ProspectanteResponseDTO>> atualizar(@PathVariable Long id,
                                                                          @RequestBody ProspectanteRequestDTO request) {
        ProspectanteResponseDTO dto = service.atualizar(id, request);

        return ResponseEntity.ok(EntityModel.of(dto,
                linkTo(methodOn(ProspectanteController.class).buscar(id)).withSelfRel()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/converter")
    public ResponseEntity<Void> converter(@PathVariable Long id) {
        service.converterParaCliente(id);
        return ResponseEntity.noContent().build();
    }
}