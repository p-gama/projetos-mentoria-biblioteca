package com.projetos.mentoria.biblioteca.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

 //   private Long idPessoa;

    private String nome;
    private Integer idade;
    private String cpf;
    private String email;

    private List<EnderecoDTO> enderecos = new ArrayList<>();

}
