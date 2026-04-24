package br.com.fiap2espa.cp4.service;

import br.com.fiap2espa.cp4.domain.model.Vendedor;
import br.com.fiap2espa.cp4.domain.repository.VendedorRepository;
import br.com.fiap2espa.cp4.dto.VendedorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VendedorService {
    private final VendedorRepository vendedorRepository;

    public VendedorDTO salvarVendedor(VendedorDTO dto) {
        Vendedor vendedor = new Vendedor();
        vendedor.setNome(dto.nome());
        vendedor.setEmail(dto.email());
        vendedor.setQualificacao(dto.qualificacao());
        vendedor.setEndereco(dto.endereco());

        vendedorRepository.save(vendedor);
        return dto;
    }

    public List<VendedorDTO> listarVendedores() {
        return vendedorRepository.findAll().stream()
                .map(v -> new VendedorDTO(v.getNome(), v.getEmail(), v.getQualificacao(), v.getEndereco()))
                .toList();
    }
}