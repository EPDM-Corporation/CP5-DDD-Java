package br.com.fiap2espa.cp4.service;

import br.com.fiap2espa.cp4.domain.model.Cliente;
import br.com.fiap2espa.cp4.domain.model.Contrato;
import br.com.fiap2espa.cp4.domain.repository.ClienteRepository;
import br.com.fiap2espa.cp4.domain.repository.ContratoRepository;
import br.com.fiap2espa.cp4.dto.ContratoRequestDTO;
import br.com.fiap2espa.cp4.dto.ContratoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratoService {

    private final ContratoRepository contratoRepository;
    private final ClienteRepository clienteRepository;

    public ContratoResponseDTO salvar(ContratoRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Contrato contrato = new Contrato();
        contrato.setDescricao(dto.descricao());
        contrato.setValor(dto.valor());
        contrato.setCliente(cliente);

        Contrato salvo = contratoRepository.save(contrato);

        return new ContratoResponseDTO(
                salvo.getId(),
                salvo.getDescricao(),
                salvo.getValor(),
                cliente.getId()
        );
    }

    public List<ContratoResponseDTO> listar() {
        return contratoRepository.findAll().stream()
                .map(c -> new ContratoResponseDTO(
                        c.getId(),
                        c.getDescricao(),
                        c.getValor(),
                        c.getCliente().getId()
                ))
                .toList();
    }

    public ContratoResponseDTO buscar(Long id) {
        Contrato c = contratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato não encontrado"));

        return new ContratoResponseDTO(
                c.getId(),
                c.getDescricao(),
                c.getValor(),
                c.getCliente().getId()
        );
    }

    public ContratoResponseDTO atualizar(Long id, ContratoRequestDTO dto) {
        Contrato c = contratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato não encontrado"));

        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        c.setDescricao(dto.descricao());
        c.setValor(dto.valor());
        c.setCliente(cliente);

        return new ContratoResponseDTO(
                c.getId(),
                c.getDescricao(),
                c.getValor(),
                cliente.getId()
        );
    }

    public void deletar(Long id) {
        contratoRepository.deleteById(id);
    }
}