package com.projetos.mentoria.biblioteca.controller;

import com.projetos.mentoria.biblioteca.controller.dto.livro.BookIdRequest;
import com.projetos.mentoria.biblioteca.domain.livro.BookItem;
import com.projetos.mentoria.biblioteca.domain.livro.ListaLivros;
import com.projetos.mentoria.biblioteca.domain.pessoa.Cliente;
import com.projetos.mentoria.biblioteca.service.ClienteService;
import com.projetos.mentoria.biblioteca.service.ListaLivrosService;
import com.projetos.mentoria.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/listas")
public class ListaLivrosController {

    @Autowired
    private final ListaLivrosService listaLivrosService;

    @Autowired
    private final LivroService livroService;

    @Autowired
    private final ClienteService clienteService;


    public ListaLivrosController(ListaLivrosService listaLivrosService, LivroService livroService, ClienteService clienteService) {
        this.listaLivrosService = listaLivrosService;
        this.livroService = livroService;
        this.clienteService = clienteService;
    }


    @PostMapping
    public ResponseEntity<ListaLivros> criarLista(@RequestBody ListaLivros lista) {
        Optional<Cliente> cliente = clienteService.findById(lista.getCliente().getIdPessoa());

        if(cliente.isEmpty()) {
            return ResponseEntity.notFound().build();
           }

        ListaLivros novaLista = listaLivrosService.criarLista(lista);
        novaLista.setCliente(cliente.get());
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

    @PostMapping("/{listaId}/adicionarLivro")
    public ResponseEntity<ListaLivros> adicionarLivroALista(@PathVariable Long listaId, @RequestBody BookIdRequest request) {
        ListaLivros lista = listaLivrosService.buscarListaPorId(listaId);

        if (lista == null) {
            return ResponseEntity.notFound().build();
        }

        String bookId = request.getBookId();
        BookItem livro = livroService.searchBookById(bookId);

        if (livro == null) {
            return ResponseEntity.notFound().build();
        }
        BookItem novoLivro = new BookItem();
        novoLivro.setVolumeInfo(livro.getVolumeInfo());
        novoLivro.setLista(lista);
        novoLivro = livroService.salvarLivro(novoLivro);
        lista.getItems().add(novoLivro);
        lista = listaLivrosService.salvarLista(lista);

        return ResponseEntity.ok(lista);

    }
}



