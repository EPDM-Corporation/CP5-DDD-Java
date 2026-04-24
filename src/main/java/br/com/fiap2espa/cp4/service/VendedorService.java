package br.com.fiap2espa.cp4.service;

import br.com.fiap2espa.cp4.domain.model.Vendedor;
import br.com.fiap2espa.cp4.domain.repository.VendedorRepository;
import br.com.fiap2espa.cp4.dto.VendedorRequestDTO;
import br.com.fiap2espa.cp4.dto.VendedorResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VendedorService {

    private final VendedorRepository repository;

    public VendedorResponseDTO salvar(VendedorRequestDTO dto) {
        Vendedor v = new Vendedor();
        v.setNome(dto.nome());
        v.setCpf(dto.cpf());
        v.setEmail(dto.email());
        v.setTelefone(dto.telefone());
        v.setQualificacao(dto.qualificacao());
        v.setEndereco(dto.endereco());

        return toDTO(repository.save(v));
    }

    public List<VendedorResponseDTO> listar() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public VendedorResponseDTO buscar(Long id) {
        Vendedor v = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendedor não encontrado"));
        return toDTO(v);
    }

    public VendedorResponseDTO atualizar(Long id, VendedorRequestDTO dto) {
        Vendedor v = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendedor não encontrado"));

        v.setNome(dto.nome());
        v.setCpf(dto.cpf());
        v.setEmail(dto.email());
        v.setTelefone(dto.telefone());
        v.setQualificacao(dto.qualificacao());
        v.setEndereco(dto.endereco());

        return toDTO(repository.save(v));
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Vendedor não encontrado");
        }
        repository.deleteById(id);
    }

    private VendedorResponseDTO toDTO(Vendedor v) {
        return new VendedorResponseDTO(
                v.getId(),
                v.getNome(),
                v.getEmail(),
                v.getQualificacao()
        );
    }
}