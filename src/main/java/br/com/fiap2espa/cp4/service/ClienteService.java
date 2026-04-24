package br.com.fiap2espa.cp4.service;

import br.com.fiap2espa.cp4.domain.model.Cliente;
import br.com.fiap2espa.cp4.domain.enums.Status;
import br.com.fiap2espa.cp4.domain.repository.ClienteRepository;
import br.com.fiap2espa.cp4.dto.ClienteRequestDTO;
import br.com.fiap2espa.cp4.dto.ClienteResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteResponseDTO salvar(ClienteRequestDTO dto) {
        Cliente c = new Cliente();
        c.setNome(dto.nome());
        c.setCpf(dto.cpf());
        c.setEmail(dto.email());
        c.setTelefone(dto.telefone());
        c.setEndereco(dto.endereco());
        c.setStatus(Status.EM_ATENDIMENTO);

        return toDTO(repository.save(c));
    }

    public List<ClienteResponseDTO> listarTodos() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public ClienteResponseDTO buscar(Long id) {
        Cliente c = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return toDTO(c);
    }

    public ClienteResponseDTO atualizar(Long id, ClienteRequestDTO dto) {
        Cliente c = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        c.setNome(dto.nome());
        c.setCpf(dto.cpf());
        c.setEmail(dto.email());
        c.setTelefone(dto.telefone());
        c.setEndereco(dto.endereco());

        return toDTO(repository.save(c));
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado");
        }
        repository.deleteById(id);
    }

    private ClienteResponseDTO toDTO(Cliente c) {
        return new ClienteResponseDTO(
                c.getId(),
                c.getNome(),
                c.getEmail(),
                c.getStatus().name()
        );
    }
}