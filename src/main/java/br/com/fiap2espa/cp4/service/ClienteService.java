package br.com.fiap2espa.cp4.service;

import br.com.fiap2espa.cp4.domain.model.Cliente;
import br.com.fiap2espa.cp4.domain.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor    //Lombok cria automáticamente o constructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente){
        //Regra de negócio: validar se o CPF já existe
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarTodos(){
        return clienteRepository.findAll();
    }

    //Adicionar depois a lógica para poder dar PostMapping("/{id}/converter")
}
