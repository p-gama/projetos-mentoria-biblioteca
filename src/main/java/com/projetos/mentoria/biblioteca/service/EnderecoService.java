package com.projetos.mentoria.biblioteca.service;

import com.projetos.mentoria.biblioteca.domain.Endereco;
import com.projetos.mentoria.biblioteca.exception.NaoEncontradoException;
import com.projetos.mentoria.biblioteca.infra.EnderecoRepository;
import com.projetos.mentoria.biblioteca.infra.external.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private CepService cepService;

    public Endereco cadastrarEndereco(String cep) {
        Endereco endereco = cepService.consultarCep(cep);

        if (endereco != null) {
            return enderecoRepository.save(endereco);
        } else {
            throw new NaoEncontradoException("CEP não encontrado");
        }
    }
}