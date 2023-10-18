package com.projetos.mentoria.biblioteca.service;

import com.projetos.mentoria.biblioteca.domain.livro.BookItem;
import com.projetos.mentoria.biblioteca.domain.livro.BookSearchResponse;
import com.projetos.mentoria.biblioteca.infra.LivroRepository;
import com.projetos.mentoria.biblioteca.infra.external.GoogleBooksApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LivroService {
    @Autowired
    private final GoogleBooksApiClient googleBooksApiClient;
    @Autowired
    private final LivroRepository livroRepository;


    public LivroService(GoogleBooksApiClient googleBooksApiClient,
                        LivroRepository livroRepository) {
        this.googleBooksApiClient = googleBooksApiClient;
        this.livroRepository = livroRepository;
    }

    public BookSearchResponse searchBooks(String query) {
         return googleBooksApiClient.searchBooks(query);
    }

    public BookItem searchBookById(String bookId) {
        return googleBooksApiClient.searchBookById(bookId);
    }

    public BookItem salvarLivro(BookItem book) {
        return livroRepository.save(book);
    }
}