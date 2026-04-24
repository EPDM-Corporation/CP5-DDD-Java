package br.com.fiap2espa.cp4.controller;

import br.com.fiap2espa.cp4.dto.AtendenteDTO;
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

    private final AtendenteService atendenteService;

    @PostMapping
    public ResponseEntity<EntityModel<AtendenteDTO>> cadastrar(@RequestBody AtendenteDTO request) {
        AtendenteDTO dto = atendenteService.salvar(request);
        //
        return ResponseEntity.ok(EntityModel.of(dto,
                linkTo(methodOn(AtendenteController.class).listar()).withRel("lista")));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<AtendenteDTO>>> listar() {
        List<EntityModel<AtendenteDTO>> atendentes = atendenteService.listar().stream()
                .map(dto -> EntityModel.of(dto))
                .toList();
        return ResponseEntity.ok(CollectionModel.of(atendentes,
                linkTo(methodOn(AtendenteController.class).listar()).withSelfRel()));
    }
}