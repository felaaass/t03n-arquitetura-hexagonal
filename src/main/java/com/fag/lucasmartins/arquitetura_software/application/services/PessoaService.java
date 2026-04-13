package com.fag.lucasmartins.arquitetura_software.application.services;

import com.fag.lucasmartins.arquitetura_software.application.ports.out.persistence.h2.PessoaRepositoryPort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    private final PessoaRepositoryPort repositoryPort;

    public PessoaService(PessoaRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    public PessoaBO cadastrarPessoa(PessoaBO pessoaBO) {
        return repositoryPort.salvar(pessoaBO);
    }
}