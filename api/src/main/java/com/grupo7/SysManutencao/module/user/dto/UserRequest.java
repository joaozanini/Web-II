package com.grupo7.SysManutencao.module.user.dto;

import com.grupo7.SysManutencao.module.user.domain.TipoUsuario;
import jakarta.validation.constraints.*;

public record UserRequest(

        @NotBlank
        String cpf,

        @NotBlank
        String nome,

        @Email
        @NotBlank
        String email,

        @NotBlank
        String telefone,

        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String cidade,
        String uf,

        @NotNull
        TipoUsuario tipo
) {}
