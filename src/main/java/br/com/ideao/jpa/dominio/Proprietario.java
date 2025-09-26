package br.com.ideao.jpa.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Proprietario {
    @Column(name = "nome_proprietario", nullable = false)
    private String nome;

    @Column(name = "telefone_proprietario", nullable = false)
    private String telefone;

    @Column(name = "email_proprietario")
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
