package com.projetos.mentoria.biblioteca.controller;

import com.projetos.mentoria.biblioteca.domain.livro.ListaLivros;
import com.projetos.mentoria.biblioteca.service.ListaLivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/listas")
public class ListaLivrosController {

    @Autowired
    private ListaLivrosService listaLivrosService;

    @PostMapping
    public ResponseEntity<ListaLivros> criarLista(@RequestBody ListaLivros lista) {
        ListaLivros novaLista = listaLivrosService.criarLista(lista);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaLista);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ListaLivros>> listarListas() {
        List<ListaLivros> listas = listaLivrosService.listarListas();
        return ResponseEntity.ok(listas);
    }
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<ListaLivros>> listarListasPorCliente(@PathVariable Long clienteId) {
        List<ListaLivros> listas = listaLivrosService.listarListasPorCliente(clienteId);
        return ResponseEntity.ok(listas);
    }

}



