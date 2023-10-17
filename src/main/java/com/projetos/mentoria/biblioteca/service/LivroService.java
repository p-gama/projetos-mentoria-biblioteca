package com.projetos.mentoria.biblioteca.service;

import com.projetos.mentoria.biblioteca.domain.livro.BookSearchResponse;
import com.projetos.mentoria.biblioteca.infra.external.GoogleBooksApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
    private final GoogleBooksApiClient googleBooksApiClient;

    @Autowired
    public LivroService(GoogleBooksApiClient googleBooksApiClient) {
        this.googleBooksApiClient = googleBooksApiClient;
    }

    public BookSearchResponse searchBooks(String query) {
         return googleBooksApiClient.searchBooks(query);
    }
}