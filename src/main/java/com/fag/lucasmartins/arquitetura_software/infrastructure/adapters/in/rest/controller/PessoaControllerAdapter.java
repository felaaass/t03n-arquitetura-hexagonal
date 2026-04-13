package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest;

import com.fag.lucasmartins.arquitetura_software.application.services.PessoaService;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.mapper.PessoaDTOMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class PessoaControllerAdapter {
    private final PessoaService pessoaService;

    public PessoaControllerAdapter(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> cadastrar(@RequestBody PessoaDTO dto) {
        PessoaBO bo = PessoaDTOMapper.toBo(dto);
        PessoaBO salvo = pessoaService.cadastrarPessoa(bo);
        PessoaDTO response = PessoaDTOMapper.toDto(salvo);

        return ResponseEntity.ok(response);
    }
}