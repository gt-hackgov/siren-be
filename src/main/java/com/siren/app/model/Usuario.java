package com.siren.app.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome é obrigatório.")
    private String nome;

    @NotNull(message = "O cargo é obrigatório.")
    private String cargo;

    @NotNull(message = "O orgao_id é obrigatório.")
    private String orgao_id;

    @NotNull(message = "O nivel_acesso é obrigatório.")
    private String nivel_acesso;

    @NotNull(message = "O email é obrigatório.")
    @Email(message = "O email deverá ser um email válido.")
    private String email;

    @NotBlank(message = "A senha é obrigatória.")
    @Size(min = 8, message = "A senha deverá ter no mínimo 8 caracteres.")
    private String senha;


    public Usuario(Long id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
