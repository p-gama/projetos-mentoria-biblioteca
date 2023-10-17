package com.projetos.mentoria.biblioteca.mapper;

import com.projetos.mentoria.biblioteca.controller.dto.livro.BookItemDTO;
import com.projetos.mentoria.biblioteca.controller.dto.livro.BookSearchResponseDTO;
import com.projetos.mentoria.biblioteca.controller.dto.livro.VolumeInfoDTO;
import com.projetos.mentoria.biblioteca.controller.dto.livro.ListaLivrosDTO;
import com.projetos.mentoria.biblioteca.domain.livro.BookSearchResponse;
import com.projetos.mentoria.biblioteca.domain.livro.VolumeInfo;
import com.projetos.mentoria.biblioteca.domain.livro.ListaLivros;
import com.projetos.mentoria.biblioteca.domain.livro.BookItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LivroMapper {

    BookItem toBookItem (BookItemDTO bookItemDTO);

    VolumeInfo toVolumeInfo (VolumeInfoDTO volumeInfoDTO);
    BookSearchResponse toBookSearchResponse (BookSearchResponseDTO bookSearchResponseDTO);

    ListaLivros toListaLivros (ListaLivrosDTO listaLivrosDTO);


    BookItemDTO toBookItemDTO (BookItem bookItem);

    VolumeInfoDTO toVolumeInfoDTO (VolumeInfo volumeInfo);
    BookSearchResponseDTO toBookSearchResponseDTO (BookSearchResponse bookSearchResponse);

    ListaLivrosDTO toListaLivrosDTO  (ListaLivros listaLivros);
}