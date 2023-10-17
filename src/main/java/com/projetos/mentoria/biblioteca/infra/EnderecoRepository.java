package com.projetos.mentoria.biblioteca.infra;

import com.projetos.mentoria.biblioteca.domain.pessoa.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, String> {

}