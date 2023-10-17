package com.projetos.mentoria.biblioteca.domain.livro;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_livro")
public class BookItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item", nullable = false)
    private String id;

    private VolumeInfo volumeInfo;

    @ManyToOne
    @JoinColumn(name = "id_lista")
    @JsonIgnore
    private ListaLivros lista;

}