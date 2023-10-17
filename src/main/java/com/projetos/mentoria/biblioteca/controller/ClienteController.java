package com.projetos.mentoria.biblioteca.controller;

import com.projetos.mentoria.biblioteca.controller.dto.pessoa.ClienteDTO;
import com.projetos.mentoria.biblioteca.domain.pessoa.Cliente;
import com.projetos.mentoria.biblioteca.mapper.ClienteMapper;
import com.projetos.mentoria.biblioteca.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private final ClienteService clienteService;

    private final ClienteMapper clienteMapper;

    public ClienteController(ClienteService clienteService, ClienteMapper clienteMapper) {
        this.clienteService = clienteService;
        this.clienteMapper = clienteMapper;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<ClienteDTO> cadastrarCliente(@RequestBody ClienteDTO cliente) {
        try {
            Cliente clienteSalvo = clienteService.salvarClienteComEndereco(clienteMapper.toCliente(cliente));
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteMapper.toClienteDTO(clienteSalvo));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        try {
            List<ClienteDTO> clientes = clienteService.listarClientes().stream()
                    .map(clienteMapper::toClienteDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(clientes);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

