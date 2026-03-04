package com.grupo7.SysManutencao.module.user.service;

import com.grupo7.SysManutencao.exception.user.UserAlreadyExists;
import com.grupo7.SysManutencao.module.mail.service.EmailService;
import com.grupo7.SysManutencao.module.user.domain.User;
import com.grupo7.SysManutencao.module.user.dto.UserRequest;
import com.grupo7.SysManutencao.module.user.dto.UserResponse;
import com.grupo7.SysManutencao.module.user.repository.UserRepository;
import com.grupo7.SysManutencao.util.Password.PasswordUtil;
import com.grupo7.SysManutencao.util.Password.RandomPasswordUtil;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;
    private final EmailService emailService;

    public UserService(UserRepository repository, EmailService emailService) {
        this.repository = repository;
        this.emailService = emailService;
    }

    public UserResponse signup(UserRequest dto) {

        if (repository.findByEmail(dto.email()).isPresent()) {
            throw new UserAlreadyExists("Já existe um usuário com esse email");
        }

        String rawPassword = RandomPasswordUtil.generate4DigitPassword();
        String salt = PasswordUtil.generateSalt();
        String hashedPassword = PasswordUtil.hashPassword(rawPassword, salt);

        User user = new User();
        user.setCpf(dto.cpf());
        user.setNome(dto.nome());
        user.setEmail(dto.email());
        user.setTelefone(dto.telefone());
        user.setCep(dto.cep());
        user.setLogradouro(dto.logradouro());
        user.setComplemento(dto.complemento());
        user.setBairro(dto.bairro());
        user.setCidade(dto.cidade());
        user.setUf(dto.uf());
        user.setTipo(dto.tipo());

        user.setPassword(hashedPassword);
        user.setSalt(salt);

        User savedUser = repository.save(user);
        emailService.sendPasswordEmail(savedUser.getEmail(), rawPassword);
        return new UserResponse(savedUser);
    }
}