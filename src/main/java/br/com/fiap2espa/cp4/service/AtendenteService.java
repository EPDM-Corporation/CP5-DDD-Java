package br.com.fiap2espa.cp4.service;

import br.com.fiap2espa.cp4.domain.model.Atendente;
import br.com.fiap2espa.cp4.domain.repository.AtendenteRepository;
import br.com.fiap2espa.cp4.dto.AtendenteDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AtendenteService {
    private final AtendenteRepository atendenteRepository;

    public AtendenteDTO salvar(AtendenteDTO dto) {
        Atendente atendente = new Atendente();
        atendente.setNome(dto.nome());
        atendente.setEmail(dto.email());
        atendente.setTipo(dto.tipo());
        atendente.setEndereco(dto.endereco());

        Atendente salvo = atendenteRepository.save(atendente);
        // Retorna o DTO (em um cenário real, você buscaria o ID do salvo aqui)
        return dto;
    }

    public List<AtendenteDTO> listar() {
        return atendenteRepository.findAll().stream()
                .map(a -> new AtendenteDTO(a.getNome(), a.getEmail(), a.getTipo(), a.getEndereco()))
                .toList();
    }
}