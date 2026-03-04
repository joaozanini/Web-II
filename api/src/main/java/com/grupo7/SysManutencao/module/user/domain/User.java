package com.grupo7.SysManutencao.module.user.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email; // login

    @Column(nullable = false, unique = true)
    private String telefone;

    private String cep;
    private String logradouro; // Tipo (Rua, Av., Alameda) + Nome + Número
    private String complemento; // Apartamento, Bloco, Sala, Conjunto (se aplicável)
    private String bairro;
    private String cidade;
    private String uf;

    private String salt;
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUsuario tipo;
}
