package br.com.fiap2espa.cp4.service;

import br.com.fiap2espa.cp4.domain.model.Usuario;
import br.com.fiap2espa.cp4.domain.repository.UsuarioRepository;
import br.com.fiap2espa.cp4.dto.UsuarioRequestDTO;
import br.com.fiap2espa.cp4.dto.UsuarioResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioResponseDTO salvar(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();

        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenha(dto.senha());
        usuario.setTelefone(dto.telefone());
        usuario.setEndereco(dto.endereco()); // 👈 direto (record)

        Usuario salvo = repository.save(usuario);

        return converter(salvo);
    }

    public List<UsuarioResponseDTO> listar() {
        return repository.findAll().stream()
                .map(this::converter)
                .toList();
    }

    public UsuarioResponseDTO buscar(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return converter(usuario);
    }

    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenha(dto.senha());
        usuario.setTelefone(dto.telefone());
        usuario.setEndereco(dto.endereco());

        return converter(usuario);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    private UsuarioResponseDTO converter(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getEndereco()
        );
    }
}