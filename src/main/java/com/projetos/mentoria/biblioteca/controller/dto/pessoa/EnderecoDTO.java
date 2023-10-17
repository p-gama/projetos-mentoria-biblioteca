package com.projetos.mentoria.biblioteca.controller.dto.pessoa;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class EnderecoDTO {

    private String cep;
    private String logradouro;
    // complemento cep
    private String complemento;
    //complemento do cliente (apto, casa, etc)
    private String complementoEndereco;
    private String bairro;
    private String localidade;
    private String uf;

}
