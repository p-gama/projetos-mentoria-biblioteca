package com.projetos.mentoria.biblioteca.mapper;

import com.projetos.mentoria.biblioteca.controller.dto.ClienteDTO;
import com.projetos.mentoria.biblioteca.domain.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente toCliente (ClienteDTO clienteDTO);

    ClienteDTO toClienteDTO(Cliente cliente);


}
