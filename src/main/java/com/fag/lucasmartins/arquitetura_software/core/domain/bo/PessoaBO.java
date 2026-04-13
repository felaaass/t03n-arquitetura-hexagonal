package com.fag.lucasmartins.arquitetura_software.core.domain.bo;

import com.fag.lucasmartins.arquitetura_software.core.domain.exceptions.DomainException;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class PessoaBO {
    private UUID id;
    private String nomeCompleto;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;

    public PessoaBO(UUID id, String nomeCompleto, String cpf, LocalDate dataNascimento, String email, String telefone) {
        validarMaioridade(dataNascimento);
        validarCpf(cpf);
        validarTelefone(telefone);
        validarEmail(email);

        this.id = id != null ? id : UUID.randomUUID();
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
    }

    private void validarMaioridade(LocalDate data) {
        if (data == null || Period.between(data, LocalDate.now()).getYears() < 18) {
            throw new DomainException("O cliente deve ter no mínimo 18 anos.");
        }
    }

    private void validarCpf(String doc) {
        if (doc == null || doc.length() != 11) {
            throw new DomainException("O CPF é obrigatório e deve possuir 11 caracteres.");
        }
    }

    private void validarTelefone(String tel) {
        if (tel == null || tel.length() != 11) {
            throw new DomainException("O telefone deve possuir 11 caracteres.");
        }
    }

    private void validarEmail(String mail) {
        if (mail == null || !mail.contains("@")) {
            throw new DomainException("O e-mail é obrigatório e deve conter '@'.");
        }
    }

    public UUID getId() { return id; }
    public String getNomeCompleto() { return nomeCompleto; }
    public String getCpf() { return cpf; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
}