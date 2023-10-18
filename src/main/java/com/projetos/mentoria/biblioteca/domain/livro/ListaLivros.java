package com.projetos.mentoria.biblioteca.domain.livro;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.projetos.mentoria.biblioteca.domain.pessoa.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Entity
@Table(name = "tb_lista_livros")
public class ListaLivros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lista", nullable = false)
    private Long idLista;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Cliente cliente;

    @Column(name = "nome_lista", nullable = false)
    private String nomeLista;

    @OneToMany(mappedBy = "lista", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<BookItem> items;

}