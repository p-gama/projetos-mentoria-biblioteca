package com.projetos.mentoria.biblioteca.controller;

import com.projetos.mentoria.biblioteca.controller.dto.livro.BookItemDTO;
import com.projetos.mentoria.biblioteca.controller.dto.livro.BookSearchResponseDTO;
import com.projetos.mentoria.biblioteca.domain.livro.BookItem;
import com.projetos.mentoria.biblioteca.domain.livro.BookSearchResponse;
import com.projetos.mentoria.biblioteca.mapper.LivroMapper;
import com.projetos.mentoria.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class LivroController {
    private final LivroService livroService;

    private final LivroMapper mapper;

    @Autowired
    public LivroController(LivroService livroService, LivroMapper mapper) {
        this.livroService = livroService;
        this.mapper = mapper;
    }

    @GetMapping("/search")
    public ResponseEntity<BookSearchResponseDTO> searchBooks(@RequestParam("query") String query) {
        BookSearchResponse searchResponse = livroService.searchBooks(query);
        return ResponseEntity.ok(mapper.toBookSearchResponseDTO(searchResponse));
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookItemDTO> getBookById(@PathVariable String bookId) {
        BookItem livro = livroService.searchBookById(bookId);

        if (livro == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(mapper.toBookItemDTO(livro));
    }
}