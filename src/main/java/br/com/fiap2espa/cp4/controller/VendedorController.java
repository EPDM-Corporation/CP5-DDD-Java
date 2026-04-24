package br.com.fiap2espa.cp4.controller;

import br.com.fiap2espa.cp4.dto.VendedorRequestDTO;
import br.com.fiap2espa.cp4.dto.VendedorResponseDTO;
import br.com.fiap2espa.cp4.service.VendedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/vendedores")
@RequiredArgsConstructor
public class VendedorController {

    private final VendedorService service;

    @PostMapping
    public ResponseEntity<EntityModel<VendedorResponseDTO>> cadastrar(@RequestBody VendedorRequestDTO request) {
        VendedorResponseDTO dto = service.salvar(request);

        return ResponseEntity.ok(EntityModel.of(dto,
                linkTo(methodOn(VendedorController.class).buscar(dto.id())).withSelfRel()));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<VendedorResponseDTO>>> listar() {
        List<EntityModel<VendedorResponseDTO>> lista = service.listar().stream()
                .map(dto -> EntityModel.of(dto,
                        linkTo(methodOn(VendedorController.class).buscar(dto.id())).withSelfRel()))
                .toList();

        return ResponseEntity.ok(CollectionModel.of(lista,
                linkTo(methodOn(VendedorController.class).listar()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<VendedorResponseDTO>> buscar(@PathVariable Long id) {
        VendedorResponseDTO dto = service.buscar(id);

        return ResponseEntity.ok(EntityModel.of(dto,
                linkTo(methodOn(VendedorController.class).buscar(id)).withSelfRel()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<VendedorResponseDTO>> atualizar(@PathVariable Long id,
                                                                      @RequestBody VendedorRequestDTO request) {
        VendedorResponseDTO dto = service.atualizar(id, request);

        return ResponseEntity.ok(EntityModel.of(dto,
                linkTo(methodOn(VendedorController.class).buscar(id)).withSelfRel()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}