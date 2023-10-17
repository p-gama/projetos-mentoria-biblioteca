package com.projetos.mentoria.biblioteca.controller.dto.pessoa;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
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
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ClienteDTO {


    private Long idPessoa;
    private String nome;
    private Integer idade;
    private String cpf;
    private String email;

    private List<EnderecoDTO> enderecos = new ArrayList<>();

}
