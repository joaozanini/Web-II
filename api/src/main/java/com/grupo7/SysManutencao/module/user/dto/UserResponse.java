package com.grupo7.SysManutencao.module.user.dto;

import com.grupo7.SysManutencao.module.user.domain.User;

public record UserResponse(
        Long id,
        String cpf,
        String nome,
        String email,
        String telefone,
        String tipo
) {
    public UserResponse(User user) {
        this(
                user.getId(),
                user.getCpf(),
                user.getNome(),
                user.getEmail(),
                user.getTelefone(),
                user.getTipo().name()
        );
    }
}
