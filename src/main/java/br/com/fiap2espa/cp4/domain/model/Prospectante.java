package br.com.fiap2espa.cp4.domain.model;

import br.com.fiap2espa.cp4.domain.enums.AreaDeInteresse;
import br.com.fiap2espa.cp4.domain.vo.Endereco;
import jakarta.persistence.*;

@Entity
public class Prospectante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
    private String email;
    private String telefone;

    @Embedded
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    private AreaDeInteresse areaDeInteresse;    //Enum

    public Prospectante() {}


    public Long id() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String nome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String email() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String telefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco endereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public AreaDeInteresse areaDeInteresse() {
        return areaDeInteresse;
    }

    public void setAreaDeInteresse(AreaDeInteresse areaDeInteresse) {
        this.areaDeInteresse = areaDeInteresse;
    }
}
