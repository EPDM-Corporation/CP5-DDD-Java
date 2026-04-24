package br.com.fiap2espa.cp4.service;

import br.com.fiap2espa.cp4.domain.model.Cliente;
import br.com.fiap2espa.cp4.domain.model.Prospectante;
import br.com.fiap2espa.cp4.domain.enums.Status;
import br.com.fiap2espa.cp4.domain.repository.ClienteRepository;
import br.com.fiap2espa.cp4.domain.repository.ProspectanteRepository;
import br.com.fiap2espa.cp4.dto.ProspectanteRequestDTO;
import br.com.fiap2espa.cp4.dto.ProspectanteResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProspectanteService {

    private final ProspectanteRepository repository;
    private final ClienteRepository clienteRepository;

    public ProspectanteResponseDTO salvar(ProspectanteRequestDTO dto) {
        Prospectante p = new Prospectante();
        p.setNome(dto.nome());
        p.setEmail(dto.email());
        p.setTelefone(dto.telefone());
        p.setAreaDeInteresse(dto.areaDeInteresse());

        return toDTO(repository.save(p));
    }

    public List<ProspectanteResponseDTO> listar() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public ProspectanteResponseDTO buscar(Long id) {
        Prospectante p = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prospecto não encontrado"));
        return toDTO(p);
    }

    public ProspectanteResponseDTO atualizar(Long id, ProspectanteRequestDTO dto) {
        Prospectante p = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prospecto não encontrado"));

        p.setNome(dto.nome());
        p.setEmail(dto.email());
        p.setTelefone(dto.telefone());
        p.setAreaDeInteresse(dto.areaDeInteresse());

        return toDTO(repository.save(p));
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Prospecto não encontrado");
        }
        repository.deleteById(id);
    }

    @Transactional
    public void converterParaCliente(Long id) {
        Prospectante p = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prospecto não encontrado"));

        Cliente c = new Cliente();
        c.setNome(p.getNome());
        c.setEmail(p.getEmail());
        c.setTelefone(p.getTelefone());
        c.setEndereco(p.getEndereco());
        c.setStatus(Status.EM_ATENDIMENTO);

        clienteRepository.save(c);
        repository.delete(p);
    }

    private ProspectanteResponseDTO toDTO(Prospectante p) {
        return new ProspectanteResponseDTO(
                p.getId(),
                p.getNome(),
                p.getEmail(),
                p.getTelefone(),
                p.getAreaDeInteresse()
        );
    }
}