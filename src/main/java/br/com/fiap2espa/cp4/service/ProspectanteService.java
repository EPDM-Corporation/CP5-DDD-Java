package br.com.fiap2espa.cp4.service;

import br.com.fiap2espa.cp4.domain.model.Prospectante;
import br.com.fiap2espa.cp4.domain.repository.ProspectanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProspectanteService {

    private final ProspectanteRepository prospectanteRepository;

    public Prospectante registrarInteresse(Prospectante prospectante) {
        return prospectanteRepository.save(prospectante);
    }

    public List<Prospectante> listarProspectos() {
        return prospectanteRepository.findAll();
    }

    // Lógica para o gerenciamento do ciclo de vida (Exemplo: converter em Cliente)
    public void converterParaCliente(Long id) {
        Prospectante prospecto = prospectanteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prospecto não encontrado"));
        // Aqui viria a lógica de negócio para criar um Cliente a partir deste Prospecto
    }
}