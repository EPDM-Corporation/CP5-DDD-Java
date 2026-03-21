package br.com.fiap2espa.cp4.domain.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Usuario() {}

    public Long id() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
