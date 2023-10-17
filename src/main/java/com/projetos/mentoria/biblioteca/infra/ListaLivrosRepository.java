package com.projetos.mentoria.biblioteca.infra;


import com.projetos.mentoria.biblioteca.domain.livro.ListaLivros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ListaLivrosRepository extends JpaRepository<ListaLivros, Long> {
    @Query("SELECT bl FROM ListaLivros bl WHERE bl.cliente.idPessoa = :clienteId")
    List<ListaLivros> findByClienteId(Long clienteId);
}