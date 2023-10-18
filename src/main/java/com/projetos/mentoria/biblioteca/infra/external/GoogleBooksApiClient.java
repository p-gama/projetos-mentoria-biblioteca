package com.projetos.mentoria.biblioteca.infra.external;

import com.projetos.mentoria.biblioteca.domain.livro.BookItem;
import com.projetos.mentoria.biblioteca.domain.livro.BookSearchResponse;
import com.projetos.mentoria.biblioteca.infra.config.GoogleBooksApiConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class GoogleBooksApiClient {

    @Autowired
    private final RestTemplate restTemplate;
    private final GoogleBooksApiConfig apiConfig;


    public GoogleBooksApiClient(RestTemplate restTemplate, GoogleBooksApiConfig apiConfig) {
        this.restTemplate = restTemplate;
        this.apiConfig = apiConfig;
    }

    public BookSearchResponse searchBooks(String query) {
        String url = apiConfig.getUrl() + "?q=" + query + "&key=" + apiConfig.getKey();
        return restTemplate.getForObject(url, BookSearchResponse.class);
    }

    public BookItem searchBookById(String bookId) {
        String googleBooksApiUrl = "https://www.googleapis.com/books/v1/volumes";
        String apiUrl = googleBooksApiUrl + "/" + bookId;

        return restTemplate.getForObject(apiUrl, BookItem.class);
    }
}