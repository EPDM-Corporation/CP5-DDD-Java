package br.com.fiap2espa.cp4.controller;

import br.com.fiap2espa.cp4.dto.VendedorDTO;
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

    private final VendedorService vendedorService;

    @PostMapping
    public ResponseEntity<EntityModel<VendedorDTO>> cadastrar(@RequestBody VendedorDTO vendedor) {
        VendedorDTO dto = vendedorService.salvarVendedor(vendedor);
        return ResponseEntity.ok(EntityModel.of(dto,
                linkTo(methodOn(VendedorController.class).listar()).withRel("lista")));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<VendedorDTO>>> listar() {
        List<EntityModel<VendedorDTO>> vendedores = vendedorService.listarVendedores().stream()
                .map(EntityModel::of)
                .toList();
        return ResponseEntity.ok(CollectionModel.of(vendedores,
                linkTo(methodOn(VendedorController.class).listar()).withSelfRel()));
    }
}