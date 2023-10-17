package com.projetos.mentoria.biblioteca.service;

import com.projetos.mentoria.biblioteca.domain.pessoa.Cliente;
import com.projetos.mentoria.biblioteca.domain.pessoa.Endereco;

import com.projetos.mentoria.biblioteca.infra.ClienteRepository;

import com.projetos.mentoria.biblioteca.infra.external.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CepService cepService;

    public Cliente salvarClienteComEndereco(Cliente cliente) {
        for (Endereco endereco : cliente.getEnderecos()) {
            endereco.setCliente(cliente);

            Endereco viaCepEndereco = cepService.consultarCep(endereco.getCep());

            if (viaCepEndereco != null) {
                endereco.setLogradouro(viaCepEndereco.getLogradouro());
                endereco.setComplemento(viaCepEndereco.getComplemento());
                endereco.setBairro(viaCepEndereco.getBairro());
                endereco.setLocalidade(viaCepEndereco.getLocalidade());
                endereco.setUf(viaCepEndereco.getUf());
            }
        }

        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }
}