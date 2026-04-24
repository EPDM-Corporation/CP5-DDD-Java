package br.com.fiap2espa.cp4.controller;

import br.com.fiap2espa.cp4.dto.UsuarioRequestDTO;
import br.com.fiap2espa.cp4.dto.UsuarioResponseDTO;
import br.com.fiap2espa.cp4.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<EntityModel<UsuarioResponseDTO>> cadastrar(@RequestBody UsuarioRequestDTO request) {

        UsuarioResponseDTO dto = usuarioService.salvar(request);

        return ResponseEntity.ok(EntityModel.of(dto,
                linkTo(methodOn(UsuarioController.class).buscar(dto.id())).withSelfRel(),
                linkTo(methodOn(UsuarioController.class).listar()).withRel("lista")));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<UsuarioResponseDTO>>> listar() {
        List<EntityModel<UsuarioResponseDTO>> lista = usuarioService.listar().stream()
                .map(dto -> EntityModel.of(dto,
                        linkTo(methodOn(UsuarioController.class).buscar(dto.id())).withSelfRel()))
                .toList();

        return ResponseEntity.ok(CollectionModel.of(lista,
                linkTo(methodOn(UsuarioController.class).listar()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<UsuarioResponseDTO>> buscar(@PathVariable Long id) {

        UsuarioResponseDTO dto = usuarioService.buscar(id);

        return ResponseEntity.ok(EntityModel.of(dto,
                linkTo(methodOn(UsuarioController.class).buscar(id)).withSelfRel(),
                linkTo(methodOn(UsuarioController.class).listar()).withRel("lista")));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<UsuarioResponseDTO>> atualizar(
            @PathVariable Long id,
            @RequestBody UsuarioRequestDTO request) {

        UsuarioResponseDTO dto = usuarioService.atualizar(id, request);

        return ResponseEntity.ok(EntityModel.of(dto,
                linkTo(methodOn(UsuarioController.class).buscar(id)).withSelfRel()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}