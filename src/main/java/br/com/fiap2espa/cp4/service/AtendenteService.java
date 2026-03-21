package br.com.fiap2espa.cp4.service;

import br.com.fiap2espa.cp4.domain.model.Atendente;
import br.com.fiap2espa.cp4.domain.repository.AtendenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AtendenteService {
    private final AtendenteRepository atendenteRepository;

    public Atendente salvar(Atendente atendente) {
        return atendenteRepository.save(atendente);
    }

    public List<Atendente> listar() {
        return atendenteRepository.findAll();
    }
}