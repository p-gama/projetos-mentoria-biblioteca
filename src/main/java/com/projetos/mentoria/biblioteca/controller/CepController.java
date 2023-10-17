package com.projetos.mentoria.biblioteca.controller;

import com.projetos.mentoria.biblioteca.controller.dto.pessoa.EnderecoDTO;
import com.projetos.mentoria.biblioteca.domain.pessoa.Endereco;
import com.projetos.mentoria.biblioteca.infra.external.CepService;
import com.projetos.mentoria.biblioteca.mapper.EnderecoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CepController {

    @Autowired
    private final CepService cepService;

    private final EnderecoMapper mapper;

    public CepController(CepService cepService, EnderecoMapper mapper) {
        this.cepService = cepService;
        this.mapper = mapper;
    }

    @GetMapping("/buscarcep/{cep}")
    public ResponseEntity<EnderecoDTO> getCep(@PathVariable String cep) {

        Endereco endereco = cepService.consultarCep(cep);

        return endereco != null ? ResponseEntity.ok().body(mapper.toEnderecoDTO(endereco)) : ResponseEntity.notFound().build();
    }

}