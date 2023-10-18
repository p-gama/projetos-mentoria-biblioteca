package com.projetos.mentoria.biblioteca.infra;


import com.projetos.mentoria.biblioteca.domain.livro.BookItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LivroRepository extends JpaRepository<BookItem, String> {
}