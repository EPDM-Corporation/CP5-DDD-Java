package br.com.fiap2espa.cp4.service;


import br.com.fiap2espa.cp4.domain.model.Vendedor;
import br.com.fiap2espa.cp4.domain.repository.VendedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VendedorService {
    private final VendedorRepository vendedorRepository;

    public Vendedor salvarVendedor(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    public List<Vendedor> listarVendedores() {
        return vendedorRepository.findAll();
    }
}
