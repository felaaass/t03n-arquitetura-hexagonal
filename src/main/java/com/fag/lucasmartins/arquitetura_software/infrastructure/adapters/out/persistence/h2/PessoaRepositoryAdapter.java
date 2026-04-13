package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2;

import com.fag.lucasmartins.arquitetura_software.application.ports.out.persistence.h2.PessoaRepositoryPort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.entities.PessoaEntity;
import com.fag.lucasmartins.arquitetura_software.infrastructure.repositories.SpringDataPessoaRepository;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.mapper.PessoaEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class PessoaRepositoryAdapter implements PessoaRepositoryPort {

    private final SpringDataPessoaRepository springDataRepository;

    public PessoaRepositoryAdapter(SpringDataPessoaRepository springDataRepository) {
        this.springDataRepository = springDataRepository;
    }

    @Override
    public PessoaBO salvar(PessoaBO pessoa) {
        PessoaEntity entity = PessoaEntityMapper.toEntity(pessoa);

        PessoaEntity savedEntity = springDataRepository.save(entity);

        return PessoaEntityMapper.toBo(savedEntity);
    }
}