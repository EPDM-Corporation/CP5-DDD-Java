package br.com.fiap2espa.cp4.controller;

import br.com.fiap2espa.cp4.dto.ProspectanteDTO;
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

    private final ProspectanteService prospectanteService;

    @PostMapping
    public ResponseEntity<EntityModel<ProspectanteDTO>> registrar(@RequestBody ProspectanteDTO prospectante) {
        ProspectanteDTO dto = prospectanteService.registrarInteresse(prospectante);
        return ResponseEntity.ok(EntityModel.of(dto,
                linkTo(methodOn(ProspectanteController.class).listar()).withRel("todos_prospectos")));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<ProspectanteDTO>>> listar() {
        List<EntityModel<ProspectanteDTO>> lista = prospectanteService.listarProspectos().stream()
                .map(EntityModel::of)
                .toList();
        return ResponseEntity.ok(CollectionModel.of(lista,
                linkTo(methodOn(ProspectanteController.class).listar()).withSelfRel()));
    }

    @PostMapping("/{id}/converter")
    public ResponseEntity<Void> converterEmCliente(@PathVariable Long id) {
        prospectanteService.converterParaCliente(id);
        return ResponseEntity.noContent().build();
    }
}