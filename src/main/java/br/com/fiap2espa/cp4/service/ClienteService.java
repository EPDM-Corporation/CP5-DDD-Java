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
    private final ClienteRepository clienteRepository;

    public ClienteResponseDTO salvar(ClienteRequestDTO request) {
        Cliente cliente = new Cliente();
        cliente.setNome(request.nome());
        cliente.setCpf(request.cpf());
        cliente.setEmail(request.email());
        cliente.setTelefone(request.telefone());
        cliente.setEndereco(request.endereco());
        cliente.setStatus(Status.EM_ATENDIMENTO); // Status inicial padrão

        Cliente salvo = clienteRepository.save(cliente);
        return converterParaResponseDTO(salvo);
    }

    public List<ClienteResponseDTO> listarTodos() {
        return clienteRepository.findAll().stream()
                .map(this::converterParaResponseDTO)
                .toList();
    }

    public ClienteResponseDTO buscar(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return converterParaResponseDTO(cliente);
    }

    private ClienteResponseDTO converterParaResponseDTO(Cliente cliente) {
        return new ClienteResponseDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getStatus().name()
        );
    }
}