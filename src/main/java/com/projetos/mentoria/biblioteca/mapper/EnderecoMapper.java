package com.projetos.mentoria.biblioteca.mapper;

import com.projetos.mentoria.biblioteca.controller.dto.pessoa.EnderecoDTO;
import com.projetos.mentoria.biblioteca.domain.pessoa.Endereco;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    Endereco toEndereco (EnderecoDTO enderecoDTO);

    EnderecoDTO toEnderecoDTO (Endereco endereco);

}
