package com.fag.lucasmartins.arquitetura_software.infrastructure.repositories;

import com.fag.lucasmartins.arquitetura_software.infrastructure.entities.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface SpringDataPessoaRepository extends JpaRepository<PessoaEntity, UUID> {
}