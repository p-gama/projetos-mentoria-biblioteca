package com.projetos.mentoria.biblioteca.mapper;

import com.projetos.mentoria.biblioteca.controller.dto.pessoa.ClienteDTO;
import com.projetos.mentoria.biblioteca.domain.pessoa.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente toCliente (ClienteDTO clienteDTO);

    ClienteDTO toClienteDTO(Cliente cliente);


}
