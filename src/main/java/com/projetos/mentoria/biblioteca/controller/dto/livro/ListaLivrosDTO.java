package com.projetos.mentoria.biblioteca.controller.dto.livro;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.projetos.mentoria.biblioteca.domain.livro.BookItem;
import com.projetos.mentoria.biblioteca.domain.pessoa.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ListaLivrosDTO {

    private Long idLista;

    private Cliente cliente;

    private String nomeLista;

    private List<BookItem> items;
}
