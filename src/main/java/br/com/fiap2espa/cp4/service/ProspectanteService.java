package br.com.fiap2espa.cp4.service;

import br.com.fiap2espa.cp4.domain.model.Cliente;
import br.com.fiap2espa.cp4.domain.model.Prospectante;
import br.com.fiap2espa.cp4.domain.enums.Status;
import br.com.fiap2espa.cp4.domain.repository.ClienteRepository;
import br.com.fiap2espa.cp4.domain.repository.ProspectanteRepository;
import br.com.fiap2espa.cp4.dto.ProspectanteDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProspectanteService {

    private final ProspectanteRepository prospectanteRepository;
    private final ClienteRepository clienteRepository;

    public ProspectanteDTO registrarInteresse(ProspectanteDTO dto) {
        Prospectante p = new Prospectante();
        p.setNome(dto.nome());
        p.setEmail(dto.email());
        p.setTelefone(dto.telefone());
        p.setAreaDeInteresse(dto.areaDeInteresse());

        prospectanteRepository.save(p);
        return dto;
    }

    public List<ProspectanteDTO> listarProspectos() {
        return prospectanteRepository.findAll().stream()
                .map(p -> new ProspectanteDTO(p.getNome(), p.getEmail(), p.getTelefone(), p.getAreaDeInteresse()))
                .toList();
    }

    @Transactional
    public void converterParaCliente(Long id) {
        Prospectante prospecto = prospectanteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prospecto não encontrado"));

        // Criando Cliente a partir dos dados do Prospecto
        Cliente novoCliente = new Cliente();
        novoCliente.setNome(prospecto.getNome());
        novoCliente.setEmail(prospecto.getEmail());
        novoCliente.setTelefone(prospecto.getTelefone());
        novoCliente.setEndereco(prospecto.getEndereco());
        novoCliente.setStatus(Status.EM_ATENDIMENTO);

        clienteRepository.save(novoCliente);
        prospectanteRepository.delete(prospecto); // Remove o prospecto após converter
    }
}