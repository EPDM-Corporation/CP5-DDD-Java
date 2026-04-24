package br.com.fiap2espa.cp4.service;

import br.com.fiap2espa.cp4.domain.model.Atendente;
import br.com.fiap2espa.cp4.domain.repository.AtendenteRepository;
import br.com.fiap2espa.cp4.dto.AtendenteRequestDTO;
import br.com.fiap2espa.cp4.dto.AtendenteResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AtendenteService {

    private final AtendenteRepository repository;

    public AtendenteResponseDTO salvar(AtendenteRequestDTO dto) {
        Atendente a = new Atendente();
        a.setNome(dto.nome());
        a.setCpf(dto.cpf());
        a.setEmail(dto.email());
        a.setTelefone(dto.telefone());
        a.setTipo(dto.tipo());
        a.setEndereco(dto.endereco());

        Atendente salvo = repository.save(a);
        return toDTO(salvo);
    }

    public List<AtendenteResponseDTO> listar() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public AtendenteResponseDTO buscar(Long id) {
        Atendente a = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Atendente não encontrado"));
        return toDTO(a);
    }

    public AtendenteResponseDTO atualizar(Long id, AtendenteRequestDTO dto) {
        Atendente a = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Atendente não encontrado"));

        a.setNome(dto.nome());
        a.setCpf(dto.cpf());
        a.setEmail(dto.email());
        a.setTelefone(dto.telefone());
        a.setTipo(dto.tipo());
        a.setEndereco(dto.endereco());

        return toDTO(repository.save(a));
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Atendente não encontrado");
        }
        repository.deleteById(id);
    }

    private AtendenteResponseDTO toDTO(Atendente a) {
        return new AtendenteResponseDTO(
                a.getId(),
                a.getNome(),
                a.getEmail(),
                a.getTipo()
        );
    }
}