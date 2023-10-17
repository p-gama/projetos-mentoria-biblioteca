package com.projetos.mentoria.biblioteca.service;

import com.projetos.mentoria.biblioteca.domain.livro.ListaLivros;
import com.projetos.mentoria.biblioteca.infra.ListaLivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaLivrosService {

    @Autowired
    private ListaLivrosRepository listaLivrosRepository;

    @Autowired
    private LivroService livroService;

    public ListaLivros criarLista(ListaLivros lista) {
        return listaLivrosRepository.save(lista);
    }

    public List<ListaLivros> listarListas() {
        return listaLivrosRepository.findAll();
    }

    public List<ListaLivros> listarListasPorCliente(Long clienteId) {
        return listaLivrosRepository.findByClienteId(clienteId);
    }

}
